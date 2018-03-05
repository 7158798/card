package com.rw.finance.admin.service.impl;

import com.rw.finance.admin.dao.MemberProfitDao;
import com.rw.finance.admin.model.MemberProfitQueryModel;
import com.rw.finance.admin.service.MemberProfitService;
import com.rw.finance.common.entity.MemberProfit;
import com.rw.finance.common.utils.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberProfitServiceImpl implements MemberProfitService {
    @Autowired
    private MemberProfitDao memberProfitDao;

    @Override
    public Page<MemberProfit> getMemberProfits(MemberProfitQueryModel model) {
        // 处理排序
        List<Sort.Order> listOrder = SortUtils.toSortOrder(model.getOrderby());
        if (model.getPage() > 0) {
            model.setPage(model.getPage() - 1);
        }

        // 处理条件
        Page<MemberProfit> info = memberProfitDao.findAll(new Specification<MemberProfit>() {
            @Override
            public Predicate toPredicate(Root<MemberProfit> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder
                    criteriaBuilder) {

                // 条件集合
                List<Predicate> predicates = new ArrayList();

                // 流水号
                if (model.getTradeno() != null && !model.getTradeno().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("tradeno"), "%" + model.getTradeno() + "%"));
                }

                // 会员编号
                if (model.getMemberid() != null && model.getMemberid() > 0) {
                    predicates.add(criteriaBuilder.equal(root.get("memberid"), model.getMemberid()));
                }

                // 状态
                if (model.getBiztype() != null && !model.getBiztype().isEmpty()) {
                    predicates.add(criteriaBuilder.equal(root.get("biztype"), model.getBiztype()));
                }

                // 判断条件
                if (predicates.size() > 0) {
                    return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
                }

                return null;
            }
        }, new PageRequest(model.getPage(), model.getSize(), new Sort(listOrder)));

        // 处理特殊
        for (MemberProfit profit : info.getContent()) {
            // 手机号码
            if (profit.getProtelephone() != null && profit.getProtelephone().length() > 7) {
                profit.setProtelephone(profit.getProtelephone().substring(0, 3) + "****" + profit.getProtelephone()
                        .substring(profit.getProtelephone().length() - 4));
            }
        }

        return info;
    }
}
