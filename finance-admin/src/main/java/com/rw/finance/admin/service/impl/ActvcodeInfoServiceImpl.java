package com.rw.finance.admin.service.impl;

import com.rw.finance.admin.dao.ActvcodeInfoDao;
import com.rw.finance.admin.dao.AgentInfoDao;
import com.rw.finance.admin.dao.OrderCountDao;
import com.rw.finance.admin.model.ActvcodeInfoQueryModel;
import com.rw.finance.admin.model.CountActvcodeEChartsModel;
import com.rw.finance.admin.service.ActvcodeInfoService;
import com.rw.finance.common.constants.OrderCountConstants;
import com.rw.finance.common.entity.ActvcodeInfo;
import com.rw.finance.common.entity.AgentInfo;
import com.rw.finance.common.entity.OrderCount;
import com.rw.finance.common.entity.PowerResource;
import com.rw.finance.common.utils.Md5Util;
import com.rw.finance.common.utils.Result;
import com.rw.finance.common.utils.SortUtils;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.management.resources.agent;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * 激活码实现
 */
@Service
public class ActvcodeInfoServiceImpl implements ActvcodeInfoService {
    @Autowired
    private ActvcodeInfoDao actvcodeInfoDao;

    @Autowired
    private OrderCountDao orderCountDao;

    @Autowired
    private AgentInfoDao agentInfoDao;

    @Override
    public Page<ActvcodeInfo> getActvcodes(ActvcodeInfoQueryModel model) {
        // 处理排序
        List<Sort.Order> listOrder = SortUtils.toSortOrder(model.getOrderby());
        if (model.getPage() > 0) {
            model.setPage(model.getPage() - 1);
        }

        // 处理条件
        return actvcodeInfoDao.findAll(new Specification<ActvcodeInfo>() {
            @Override
            public Predicate toPredicate(Root<ActvcodeInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder
                    criteriaBuilder) {

                // 条件集合
                List<Predicate> predicates = new ArrayList();

                // 激活码
                if (model.getActivecode() != null && !model.getActivecode().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("activecode"), "%" + model.getActivecode() + "%"));
                }

                // 代理编号
                if (model.getAgentid() != null && model.getAgentid() > 0) {
                    predicates.add(criteriaBuilder.equal(root.get("agentid"), model.getAgentid()));
                }

                // 使用状态
                if (model.getUsestatus() != null && model.getUsestatus() != 99) {
                    predicates.add(criteriaBuilder.equal(root.get("usestatus"), model.getUsestatus()));
                }

                // 是否可售
                if (model.getSalestatus() != null && model.getSalestatus() != 99) {
                    predicates.add(criteriaBuilder.equal(root.get("salestatus"), model.getSalestatus()));
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
    @Transactional
    public Result saveActvcode(Long agentid, Integer count, Integer level, Integer issale, Double price) {
        // 代理信息
        AgentInfo agent = agentInfoDao.findOne(agentid);
        if (agent == null || agent.getStatus() != 1) {
            return new Result(202, "代理不存在或状态已关闭", null);
        }

        // 循环生成
        for (int j = 0; j < count; j++) {
            ActvcodeInfo model = new ActvcodeInfo();
            model.setActivecode(Md5Util.md5To16(UUID.randomUUID().toString()));
            model.setAgentid(agentid);
            model.setAgentname(agent.getAgentname());
            model.setLevel(level);
            model.setPrice(price);
            model.setUsestatus(issale);
            model.setSalestatus(issale);
            model.setCreatetime(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            actvcodeInfoDao.save(model);

            OrderCount orderCount = new OrderCount();
            orderCount.setMemberprofittotal(0D);
            orderCount.setAgentprofittotal(0D);
            orderCount.setCompanyprofittotal(price);
            orderCount.setTradeamount(price);
            orderCount.setTradeno(model.getActivecode());
            orderCount.setCreatetime(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            orderCount.setTradetype(OrderCountConstants.TradeType.ActvcodeSale.getTradeType());
            orderCountDao.save(orderCount);
        }

        return new Result(200, "生成成功", null);
    }

    @Override
    @Transactional
    public Result grantActvcode(long fromid, long toid, int count) {
        if (count <= 0) {
            return new Result(202, "下放个数必须大于0", null);
        }

        AgentInfo from = agentInfoDao.findOne(fromid);
        if (from == null || from.getStatus() != 1) {
            return new Result(202, "代理信息不存在或状态已关闭", null);
        }

        if (from.getAgentlevel().intValue() <= 0 || from.getAgentlevel().intValue() >= 3) {
            return new Result(202, "代理无法执行该操作", null);
        }

        AgentInfo to = agentInfoDao.findOne(toid);
        if (to == null || to.getStatus() != 1) {
            return new Result(202, "目标代理不存在或状态已关闭", null);
        }

        if (to.getParentid().longValue() != fromid) {
            return new Result(202, "目标代理非直属下级代理", null);
        }

        List<ActvcodeInfo> list = actvcodeInfoDao.findAllByAgentidAndSalestatusAndUsestatus(fromid, 1, 1);
        if (list == null || list.size() <= 0) {
            return new Result(202, "无可用激活码", null);
        }

        if (count > list.size()) {
            return new Result(202, "可用激活码不足" + String.valueOf(count) + "个，缺口为" + String.valueOf(count - list.size()
            ) + "个", null);
        }

        for (int j = 0; j < count; j++) {
            ActvcodeInfo model = list.get(j);
            model.setAgentid(toid);
            model.setAgentname(to.getAgentname());
            actvcodeInfoDao.save(model);
        }

        return new Result(200, "下放成功", null);
    }

    @Override
    @Transactional
    public void updateUseStatus(List<Long> activeid, Integer status) {
        Iterable<ActvcodeInfo> list = actvcodeInfoDao.findAll(activeid);
        if (list == null) {
            return;
        }

        for (ActvcodeInfo item : list) {
            if (item.getUsestatus() != status) {
                item.setUsestatus(status);
                if (status.intValue() == 1 && (item.getUsetime() == null || item.getUsetime().isEmpty())) {
                    item.setUsetime(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
                }

                if (status != 1 && item.getUsetime() != null && !item.getUsetime().isEmpty()) {
                    item.setMemberid(0L);
                    item.setUsetime("");
                }

                actvcodeInfoDao.save(item);
            }
        }
    }

    @Override
    @Transactional
    public void updateSaleStatus(List<Long> activeid, Integer status) {
        Iterable<ActvcodeInfo> list = actvcodeInfoDao.findAll(activeid);
        if (list == null) {
            return;
        }

        for (ActvcodeInfo item : list) {
            if (item.getUsestatus() != 2 && item.getSalestatus() != status) {
                item.setUsestatus(status);
                item.setSalestatus(status);
                actvcodeInfoDao.save(item);
            }
        }
    }

    @Override
    public CountActvcodeEChartsModel getActvcodeCount(Long agentid, String start, String end) {
        // 代理信息
        AgentInfo agentInfo = this.agentInfoDao.findOne(agentid);
        if (agentInfo == null) {
            return null;
        }

        // 统计结果
        CountActvcodeEChartsModel model = new CountActvcodeEChartsModel();

        // 日期集合
        List<String> date = com.rw.finance.common.utils.DateUtils.getDateList(start, end);
        model.setDate(date);

        // 周期开始与结束
        start = date.get(0) + " 00:00:00";
        end = date.get(date.size() - 1) + " 23:59:59";

        // 统计数量
        List<Long> countAdd = new ArrayList();
        List<Long> countActvd = new ArrayList();

        // 数据集合
        List<ActvcodeInfo> actvcodeInfoList = null;
        List<ActvcodeInfo> actvdList = null;
        if (agentInfo.getAgentlevel() > 0) {
            actvcodeInfoList = actvcodeInfoDao.findByAgentidAndSalestatusAndCreatetimeBetween(agentid, 1, start, end);
            actvdList = actvcodeInfoDao.findByAgentidAndUsestatusAndUsetimeBetween(agentid, 2, start, end);
        } else {
            actvcodeInfoList = actvcodeInfoDao.findBySalestatusAndCreatetimeBetween(1, start, end);
            actvdList = actvcodeInfoDao.findByUsestatusAndUsetimeBetween(2, start, end);
        }

        // 循环统计
        for (String item : date) {
            if (actvcodeInfoList == null || actvcodeInfoList.size() <= 0) {
                countAdd.add(0L);
            } else {
                Long date_1 = com.rw.finance.common.utils.DateUtils.getTimeByStr(item + " 00:00:00").getTime();
                Long date_2 = com.rw.finance.common.utils.DateUtils.getTimeByStr(item + " 23:59:59").getTime();

                // 新增总量
                countAdd.add(actvcodeInfoList.stream().filter(s -> com.rw.finance.common.utils.DateUtils
                        .getTimeByStr(s.getCreatetime()).getTime() >= date_1 && com.rw.finance.common.utils.DateUtils
                        .getTimeByStr(s.getCreatetime()).getTime() <= date_2).count());
            }

            if (actvdList == null || actvdList.size() <= 0) {
                countActvd.add(0L);
            } else {
                Long date_1 = com.rw.finance.common.utils.DateUtils.getTimeByStr(item + " 00:00:00").getTime();
                Long date_2 = com.rw.finance.common.utils.DateUtils.getTimeByStr(item + " 23:59:59").getTime();

                // 新增总量
                countActvd.add(actvdList.stream().filter(s -> com.rw.finance.common.utils.DateUtils
                        .getTimeByStr(s.getUsetime()).getTime() >= date_1 && com.rw.finance.common.utils.DateUtils
                        .getTimeByStr(s.getUsetime()).getTime() <= date_2).count());
            }
        }

        model.setAddcount(countAdd);
        model.setUsecount(countActvd);
        return model;
    }
}
