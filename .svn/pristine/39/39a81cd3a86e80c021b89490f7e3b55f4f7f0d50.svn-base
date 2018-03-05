package com.rw.finance.admin.controller;

import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.service.PlatformCountService;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 统计控制
 */
@RestController
@RequestMapping(value = "/count")
public class PlatformCountController {
    @Autowired
    private PlatformCountService platformCountService;

    /**
     * 代理首页合计
     *
     * @param agentid
     * @return
     */
    @PostMapping(value = "/getagentindextotal")
    @AgentInfoAuthor(level = 99)
    public Result getAgentIndexTotal(@RequestAttribute(value = "agentid", required = true) Long agentid) {
        return new Result(200, null, this.platformCountService.getAgentIndexTotal(agentid));
    }

    /**
     * 平台首页合计
     *
     * @return
     */
    @PostMapping(value = "/getadminindextotal")
    @AgentInfoAuthor(level = 0)
    public Result getAdminIndexTotal() {
        return new Result(200, null, this.platformCountService.getAdminIndexTotal());
    }
}
