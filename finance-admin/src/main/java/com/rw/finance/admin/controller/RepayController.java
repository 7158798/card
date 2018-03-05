package com.rw.finance.admin.controller;

import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.model.RepayPlanQueryModel;
import com.rw.finance.admin.service.RepayPlanService;
import com.rw.finance.admin.service.RepayTaskService;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 还款控制
 */
@RestController
@RequestMapping(value = "/repay")
public class RepayController {
    @Autowired
    private RepayPlanService repayPlanService;

    @Autowired
    private RepayTaskService repayTaskService;

    /**
     * 查询计划列表
     *
     * @param queryModel
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getrepayplans")
    public Result getRepayPlans(RepayPlanQueryModel queryModel) {
        return new Result(200, "", this.repayPlanService.getRepayPlans(queryModel));
    }

    /**
     * 查询任务列表
     *
     * @param planid
     * @param status
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getrepaytasks")
    public Result getRepayTasks(@RequestParam(name = "planid", required = true) Long planid, @RequestParam(name =
            "status", required = true) Integer status) {
        return new Result(200, "", this.repayTaskService.getRepayTasks(planid, status));
    }
}
