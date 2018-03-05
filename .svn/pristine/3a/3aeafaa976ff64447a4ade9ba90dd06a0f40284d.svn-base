package com.rw.finance.admin.service.impl;

import com.rw.finance.admin.dao.AgentInfoDao;
import com.rw.finance.admin.dao.AgentProfitDao;
import com.rw.finance.admin.model.AgentProfitQueryModel;
import com.rw.finance.admin.model.CountAgentProfitEChartsModel;
import com.rw.finance.admin.model.OrderInfoCountModel;
import com.rw.finance.admin.service.AgentProfitService;
import com.rw.finance.common.entity.AgentInfo;
import com.rw.finance.common.entity.AgentProfit;
import com.rw.finance.common.utils.DateUtils;
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
import java.util.stream.Stream;

/**
 * 代理收益实现
 */
@Service
public class AgentProfitServiceImpl implements AgentProfitService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private AgentInfoDao agentInfoDao;

    @Autowired
    private AgentProfitDao agentProfitDao;

    @Override
    public Page<AgentProfit> getAgentProfits(AgentProfitQueryModel model) {
        // 处理排序
        List<Sort.Order> listOrder = SortUtils.toSortOrder(model.getOrderby());
        if (model.getPage() > 0) {
            model.setPage(model.getPage() - 1);
        }

        // 处理条件
        return agentProfitDao.findAll(new Specification<AgentProfit>() {
            @Override
            public Predicate toPredicate(Root<AgentProfit> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder
                    criteriaBuilder) {

                // 条件集合
                List<Predicate> predicates = new ArrayList();

                // 代理编号
                if (model.getAgentid() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("agentid"), model.getAgentid()));
                }

                // 流水号
                if (model.getTradeno() != null && !model.getTradeno().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("tradeno"), "%" + model.getTradeno() +
                            "%"));
                }

                // 收益类型
                if (model.getType() != 99) {
                    predicates.add(criteriaBuilder.equal(root.get("profittype"), model.getType()));
                }

                // 判断条件
                if (predicates.size() > 0) {
                    return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
                }

                return null;
            }
        }, new PageRequest(model.getPage(), model.getSize(), new Sort(listOrder)));
    }

    @Override
    public CountAgentProfitEChartsModel getProfitCount(Long agentid, String type) {
        // 代理信息
        AgentInfo agentInfo = this.agentInfoDao.findOne(agentid);
        if (agentInfo == null) {
            return null;
        }

        // 统计结果
        CountAgentProfitEChartsModel model = new CountAgentProfitEChartsModel();

        //region 日期区间

        // 日期集合
        List<String> date = DateUtils.getDateList(type);
        String start = date.get(0) + " 00:00:00";
        String end = date.get(date.size() - 1) + " 23:59:59";
        model.setDate(date);

        //endregion

        // 统计SQL
        String sql = "";
        if (agentInfo.getAgentlevel() > 0) {
            sql = "SELECT DATE_FORMAT(create_time,\"%Y-%m-%d\") as date,SUM(amount) as amount " +
                    "FROM (SELECT amount,create_time FROM agent_profit WHERE agent_id = " + agentInfo
                    .getAgentid() + " and create_time >= '" + start + "' AND create_time <= '" + end + "') A GROUP BY" +
                    " DATE_FORMAT(create_time, \"%Y-%m-%d\")";
        } else {
            sql = "SELECT DATE_FORMAT(createtime,\"%Y-%m-%d\") as date,SUM(companyprofittotal) as amount " +
                    "FROM (SELECT companyprofittotal,createtime FROM order_count WHERE createtime >= '" + start + "' " +
                    "AND createtime <= '" + end + "') A GROUP BY DATE_FORMAT(createtime, \"%Y-%m-%d\")";
        }

        // 统计结果
        Query dataQuery = em.createNativeQuery(sql);
        List<Object[]> listData = dataQuery.getResultList();

        // 实体封装
        List<OrderInfoCountModel> list = new ArrayList<OrderInfoCountModel>();
        for (Object[] item : listData) {
            OrderInfoCountModel model1 = new OrderInfoCountModel();
            model1.setDate(item[0].toString());
            model1.setAmount(Double.parseDouble(item[1].toString()));
            list.add(model1);
        }

        // 统计明细
        List<Double> total = new ArrayList();

        // 循环统计
        for (String item : date) {
            if (list == null || list.size() <= 0) {
                total.add(0D);
            } else {
                Stream stream = list.stream().filter(s -> s.getDate().equals(item));
                if (stream != null && stream.count() == 1) {
                    list.stream().filter(s -> s.getDate().equals(item)).forEach(p -> {
                        total.add(p.getAmount());
                    });
                } else {
                    total.add(0D);
                }
            }
        }

        model.setTotalamount(total);
        return model;
    }
}
