package com.rw.finance.admin.service;

import com.rw.finance.admin.model.RepayPlanQueryModel;
import com.rw.finance.common.entity.RepayPlan;
import org.springframework.data.domain.Page;

/**
 * 还款计划接口
 */
public interface RepayPlanService {
    /**
     * 查询还款计划列表
     *
     * @param model
     * @return
     */
    Page<RepayPlan> getRepayPlans(RepayPlanQueryModel model);
}
