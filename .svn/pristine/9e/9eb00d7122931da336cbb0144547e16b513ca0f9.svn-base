package com.rw.finance.admin.controller;

import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.model.AgentProfitQueryModel;
import com.rw.finance.admin.service.AgentProfitService;
import com.rw.finance.common.entity.AgentProfit;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 代理收益
 */
@RestController
@RequestMapping(value = "/agentprofit")
public class AgentProfitController {
    @Autowired
    private AgentProfitService agentProfitService;

    /**
     * 获取收益列表
     *
     * @param query
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getagentprofits")
    public Result getAgentProfits(AgentProfitQueryModel query) {
        Page<AgentProfit> data = agentProfitService.getAgentProfits(query);
        return new Result(200, null, data);
    }

    /**
     * 统计代理收益
     *
     * @param agentid
     * @param type
     * @return
     */
    @PostMapping(value = "/getprofitcount")
    @AgentInfoAuthor(level = 99)
    public Result getProfitCount(@RequestAttribute(value = "agentid", required = true) Long agentid, @RequestParam
            (value = "type", required = true) String type) {
        return new Result(200, null, this.agentProfitService.getProfitCount(agentid, type));
    }
}
