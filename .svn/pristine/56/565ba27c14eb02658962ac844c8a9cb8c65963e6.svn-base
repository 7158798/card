package com.rw.finance.admin.service.impl;

import com.rw.finance.admin.dao.OrderCountDao;
import com.rw.finance.admin.model.CountProfitEChartsModel;
import com.rw.finance.admin.model.OrderCountQueryModel;
import com.rw.finance.admin.service.OrderCountService;
import com.rw.finance.common.entity.OrderCount;
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

@Service
public class OrderCountServiceImpl implements OrderCountService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private OrderCountDao orderCountDao;

    @Override
    public Page<OrderCount> getOrderCounts(OrderCountQueryModel model) {
        // 处理排序
        List<Sort.Order> listOrder = SortUtils.toSortOrder(model.getOrderby());
        if (model.getPage() > 0) {
            model.setPage(model.getPage() - 1);
        }

        Page<OrderCount> infos = orderCountDao.findAll(new Specification<OrderCount>() {
            @Override
            public Predicate toPredicate(Root<OrderCount> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder
                    criteriaBuilder) {
                // 条件集合
                List<Predicate> predicates = new ArrayList();

                // 交易类型
                String obj = "99";
                if (model.getTradetype() != null && !model.getTradetype().isEmpty() && !model.getTradetype().equals
                        (obj)) {
                    predicates.add(criteriaBuilder.equal(root.get("tradetype"), model.getTradetype()));
                }

                // 交易流水号
                if (model.getTradeno() != null && !model.getTradeno().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("tradeno"), "%" + model.getTradeno() + "%"));
                }

                // 开始日期
                if (model.getStartdate() != null && !model.getStartdate().isEmpty()) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createtime"), model.getStartdate()
                            + " 00:00:00"));
                }

                // 结束日期
                if (model.getEnddate() != null && !model.getEnddate().isEmpty()) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createtime"), model.getEnddate()
                            + " 23:59:59"));
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
    public CountProfitEChartsModel getProfitCount(String start, String end) {
        // 统计结果
        CountProfitEChartsModel model = new CountProfitEChartsModel();

        //region 处理日期

        // 日期集合
        List<String> date = DateUtils.getDateList(start, end);
        model.setDate(date);

        //endregion

        // 周期开始与结束
        start = date.get(0) + " 00:00:00";
        end = date.get(date.size() - 1) + " 23:59:59";

        // 统计SQL
        String sql = "SELECT B.* FROM (SELECT DATE_FORMAT(createtime,\"%Y-%m-%d\") as date,SUM(memberprofittotal) as " +
                "memberprofittotal,SUM(agentprofittotal) as agentprofittotal,SUM(companyprofittotal) as " +
                "companyprofittotal,SUM(tradeamount) as tradeamount FROM (SELECT memberprofittotal,agentprofittotal," +
                "companyprofittotal,tradeamount,createtime FROM order_count WHERE createtime >= '" +
                start + "' AND createtime <= '" + end + "') A GROUP BY DATE_FORMAT(createtime, \"%Y-%m-%d\")) B ORDER" +
                " BY B.date";

        // 统计结果
        Query dataQuery = em.createNativeQuery(sql);
        List<Object[]> listData = dataQuery.getResultList();

        // 统计明细
        List<Double> memberprofittotal = new ArrayList();
        List<Double> agentprofittotal = new ArrayList();
        List<Double> companyprofittotal = new ArrayList();
        List<Double> tradeamount = new ArrayList();

        // 实体封装
        for (String item : date) {
            if (listData != null && listData.size() > 0) {
                double amount1 = 0D;
                double amount2 = 0D;
                double amount3 = 0D;
                double amount4 = 0D;
                for (Object[] data : listData) {
                    String indate = data[0].toString();
                    if (indate.equals(item)) {
                        amount1 = Double.parseDouble(data[1].toString());
                        amount2 = Double.parseDouble(data[2].toString());
                        amount3 = Double.parseDouble(data[3].toString());
                        amount4 = Double.parseDouble(data[4].toString());
                    }
                }

                memberprofittotal.add(amount1);
                agentprofittotal.add(amount2);
                companyprofittotal.add(amount3);
                tradeamount.add(amount4);
            } else {
                memberprofittotal.add(0D);
                agentprofittotal.add(0D);
                companyprofittotal.add(0D);
                tradeamount.add(0D);
            }
        }

        model.setMemberprofit(memberprofittotal);
        model.setAgentprofit(agentprofittotal);
        model.setCompanyprofit(companyprofittotal);
        model.setTotal(tradeamount);
        return model;
    }
}
