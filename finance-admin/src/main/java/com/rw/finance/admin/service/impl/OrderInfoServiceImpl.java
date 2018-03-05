package com.rw.finance.admin.service.impl;

import com.rw.finance.admin.dao.AgentInfoDao;
import com.rw.finance.admin.dao.MemberInfoDao;
import com.rw.finance.admin.dao.OrderInfoDao;
import com.rw.finance.admin.model.CountOrderEChartsModel;
import com.rw.finance.admin.model.OrderInfoCountModel;
import com.rw.finance.admin.model.OrderInfoQueryModel;
import com.rw.finance.admin.service.OrderInfoService;
import com.rw.finance.common.entity.AgentInfo;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.entity.OrderInfo;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.MathUtils;
import com.rw.finance.common.utils.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 订单实现接口
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Autowired
    private AgentInfoDao agentInfoDao;

    @Autowired
    private MemberInfoDao memberInfoDao;

    @Override
    public Page<OrderInfo> getOrderInfos(OrderInfoQueryModel model) {
        // 处理排序
        List<Sort.Order> listOrder = SortUtils.toSortOrder(model.getOrderby());
        if (model.getPage() > 0) {
            model.setPage(model.getPage() - 1);
        }

        Page<OrderInfo> infos = orderInfoDao.findAll(new Specification<OrderInfo>() {
            @Override
            public Predicate toPredicate(Root<OrderInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder
                    criteriaBuilder) {
                // 条件集合
                List<Predicate> predicates = new ArrayList();

                // 用户编号
                if (model.getUserid() != null && model.getUserid() > 0) {
                    predicates.add(criteriaBuilder.equal(root.get("userid"), model.getUserid()));
                }

                // 代理编号
                if (model.getAgentid() != null && model.getAgentid() > 0) {
                    // 会员相关
                    CriteriaBuilder.In<Object> typeIn = criteriaBuilder.in(root.get("type"));
                    for (int j = 0; j < 4; j++) {
                        typeIn.value(j);
                    }

                    typeIn.value(5);

                    // 会员编号
                    List<Long> longs = null;
                    List<MemberInfo> list = memberInfoDao.findByAgentid(model.getAgentid());
                    if (list != null && list.size() > 0) {
                        longs = list.stream().filter(s -> s.getMemberid() != null).map(s -> s.getMemberid())
                                .collect(Collectors.toList());

                        // 组装编号
                        CriteriaBuilder.In<Object> useridIn = criteriaBuilder.in(root.get("userid"));
                        for (Long id : longs) {
                            useridIn.value(id);
                        }

                        predicates.add(criteriaBuilder.or(criteriaBuilder.and(useridIn, typeIn), criteriaBuilder.and
                                (criteriaBuilder.equal(root.get("userid"), model.getAgentid()),
                                        criteriaBuilder.equal(root.get("type"), 4))));
                    } else {
                        predicates.add(criteriaBuilder.and
                                (criteriaBuilder.equal(root.get("userid"), model.getAgentid()),
                                        criteriaBuilder.equal(root.get("type"), 4)));
                    }
                }

                // 手机号码
                if (model.getMobile() != null && !model.getMobile().isEmpty()) {
                    List<Long> longs = new ArrayList<>();
                    List<Long> memberid = memberInfoDao.findMemberidByMobile(model.getMobile());
                    if (memberid != null && memberid.size() > 0) {
                        longs.addAll(memberid);
                    }

                    List<Long> agentid = agentInfoDao.findAgentidByMobile(model.getMobile());
                    if (agentid != null && agentid.size() > 0) {
                        longs.addAll(agentid);
                    }

                    if (longs != null && longs.size() > 0) {
                        CriteriaBuilder.In<Object> useridIn = criteriaBuilder.in(root.get("userid"));
                        for (Long id : longs) {
                            useridIn.value(id);
                        }

                        predicates.add(useridIn);
                    }
                }

                // 订单流水号
                if (model.getTradeno() != null && !model.getTradeno().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("tradeno"), "%" + model.getTradeno() + "%"));
                }

                // 通道流水号
                if (model.getOuttradeno() != null && !model.getOuttradeno().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("outtradeno"), "%" + model.getOuttradeno() + "%"));
                }

                // 用户名称
                if (model.getUsername() != null && !model.getUsername().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("username"), "%" + model.getUsername() + "%"));
                }

                // 类型
                if (model.getType() != null && model.getType() != 99) {
                    predicates.add(criteriaBuilder.equal(root.get("type"), model.getType()));
                }

                // 状态
                if (model.getStatus() != null && model.getStatus() != 99) {
                    predicates.add(criteriaBuilder.equal(root.get("status"), model.getStatus()));
                }

                // 判断条件
                if (predicates.size() > 0) {
                    return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
                }

                return null;
            }
        }, new PageRequest(model.getPage(), model.getSize(), new Sort(listOrder)));
        return infos;
    }

    @Override
    public CountOrderEChartsModel getOrderCount(Long agentid, String start, String end) {
        // 代理信息
        AgentInfo agentInfo = this.agentInfoDao.findOne(agentid);
        if (agentInfo == null) {
            return null;
        }

        // 统计结果
        CountOrderEChartsModel model = new CountOrderEChartsModel();

        //region 处理日期

        // 日期集合
        List<String> date = DateUtils.getDateList(start, end);
        model.setDate(date);

        //endregion

        // 周期开始与结束
        start = date.get(0) + " 00:00:00";
        end = date.get(date.size() - 1) + " 23:59:59";

        // 统计SQL
        String sql = "SELECT DATE_FORMAT(create_time,\"%Y-%m-%d\") as date,type,SUM(order_amount) as amount FROM " +
                "(SELECT order_amount,create_time,type FROM order_info WHERE status = 1 AND create_time >= '" +
                start + "' AND create_time <= '" + end + "') A GROUP BY DATE_FORMAT(create_time, \"%Y-%m-%d\")," +
                "type";
        if (agentInfo.getAgentlevel() > 0) {
            StringBuilder stringId = new StringBuilder();
            List<MemberInfo> list = memberInfoDao.findByAgentid(agentInfo.getAgentid());
            if (list != null && list.size() > 0) {
                list.stream().filter(s -> s.getMemberid() != null).map(s -> s.getMemberid()).forEach((item) -> {
                    if (stringId.length() > 0) {
                        stringId.append(",");
                    }

                    stringId.append(item.toString());
                });
            }

            if (stringId.length() > 0) {
                sql = "SELECT DATE_FORMAT(create_time,\"%Y-%m-%d\") as date,type,SUM(order_amount) as amount FROM " +
                        "(SELECT order_amount,create_time,type FROM order_info WHERE status = 1 AND ((user_id = " +
                        "" + agentInfo.getAgentid() + " and type = 4) or (user_id in (" + stringId + ") and type in " +
                        "(0,1,2,3,5))) AND create_time >= '" + start + "' AND create_time <= '" + end + "') A GROUP " +
                        "BY " +
                        "DATE_FORMAT(create_time, \"%Y-%m-%d\"),type";
            } else {
                sql = "SELECT DATE_FORMAT(create_time,\"%Y-%m-%d\") as date,type,SUM(order_amount) as amount FROM " +
                        "(SELECT order_amount,create_time,type FROM order_info WHERE status = 1 AND user_id = " +
                        "" + agentInfo.getAgentid() + " and type = 4 AND create_time >= '" + start + "' AND " +
                        "create_time <= '" + end + "') A GROUP BY " +
                        "DATE_FORMAT(create_time, \"%Y-%m-%d\"),type";
            }
        }

        // 统计结果
        Query dataQuery = em.createNativeQuery(sql);
        List<Object[]> listData = dataQuery.getResultList();

        // 实体封装
        List<OrderInfoCountModel> list = new ArrayList<OrderInfoCountModel>();
        for (Object[] item : listData) {
            OrderInfoCountModel model1 = new OrderInfoCountModel();
            model1.setDate(item[0].toString());
            model1.setType(Integer.parseInt(item[1].toString()));
            model1.setAmount(Double.parseDouble(item[2].toString()));
            list.add(model1);
        }


        // 统计明细
        List<Double> total = new ArrayList();
        List<Double> type0 = new ArrayList();
        List<Double> type1 = new ArrayList();
        List<Double> type2 = new ArrayList();
        List<Double> type3 = new ArrayList();
        List<Double> type4 = new ArrayList();
        List<Double> type5 = new ArrayList();

        // 循环统计
        for (String item : date) {
            if (list == null || list.size() <= 0) {
                total.add(0D);
                type0.add(0D);
                type1.add(0D);
                type2.add(0D);
                type3.add(0D);
                type4.add(0D);
                type5.add(0D);
            } else {
                Double countTotal = 0D;
                Double countItem = 0D;

                // 代还
                Stream stream0 = list.stream().filter(s -> s.getDate().equals(item) && s.getType() == 0);
                if (stream0 != null && stream0.count() > 0) {
                    countItem = list.stream().filter(s -> s.getDate().equals(item) && s.getType() == 0).findFirst()
                            .get().getAmount();
                }

                countTotal = MathUtils.add(countTotal, countItem);
                type0.add(countItem);

                // 提现
                countItem = 0D;
                Stream stream1 = list.stream().filter(s -> s.getDate().equals(item) && s.getType() == 1);
                if (stream1 != null && stream1.count() > 0) {
                    countItem = list.stream().filter(s -> s.getDate().equals(item) && s.getType() == 1).findFirst()
                            .get().getAmount();
                }

                countTotal = MathUtils.add(countTotal, countItem);
                type1.add(countItem);

                // 收款
                countItem = 0D;
                Stream stream2 = list.stream().filter(s -> s.getDate().equals(item) && s.getType() == 2);
                if (stream2 != null && stream2.count() > 0) {
                    countItem = list.stream().filter(s -> s.getDate().equals(item) && s.getType() == 2).findFirst()
                            .get().getAmount();
                }

                countTotal = MathUtils.add(countTotal, countItem);
                type2.add(countItem);

                // 激活
                countItem = 0D;
                Stream stream3 = list.stream().filter(s -> s.getDate().equals(item) && s.getType() == 3);
                if (stream3 != null && stream3.count() > 0) {
                    countItem = list.stream().filter(s -> s.getDate().equals(item) && s.getType() == 3).findFirst()
                            .get().getAmount();
                }

                countTotal = MathUtils.add(countTotal, countItem);
                type3.add(countItem);

                // 代理提现
                countItem = 0D;
                Stream stream4 = list.stream().filter(s -> s.getDate().equals(item) && s.getType() == 4);
                if (stream4 != null && stream4.count() > 0) {
                    countItem = list.stream().filter(s -> s.getDate().equals(item) && s.getType() == 4).findFirst()
                            .get().getAmount();
                }

                countTotal = MathUtils.add(countTotal, countItem);
                type4.add(countItem);

                // 贷记卡鉴权
                countItem = 0D;
                Stream stream5 = list.stream().filter(s -> s.getDate().equals(item) && s.getType() == 5);
                if (stream5 != null && stream5.count() > 0) {
                    countItem = list.stream().filter(s -> s.getDate().equals(item) && s.getType() == 5).findFirst()
                            .get().getAmount();
                }

                countTotal = MathUtils.add(countTotal, countItem);
                type5.add(countItem);
                total.add(countTotal);
            }
        }

        model.setTotal(total);
        model.setType0(type0);
        model.setType1(type1);
        model.setType2(type2);
        model.setType3(type3);
        model.setType4(type4);
        model.setType5(type5);
        return model;
    }
}
