package com.rw.finance.admin.controller;

import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.service.AgentTypeService;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代理类型
 */
@RestController
@RequestMapping(value = "/agenttype")
public class AgentTypeController {
    @Autowired
    private AgentTypeService agentTypeService;

    /**
     * 数据信息
     *
     * @param typeid
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getinfo")
    public Result getInfo(@RequestParam(value = "typeid", required = true) long typeid) {
        return new Result(200, null, this.agentTypeService.getAgentType(typeid));
    }

    /**
     * 数据列表
     *
     * @param level
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getlist")
    public Result getList(@RequestParam(value = "level", required = true) int level) {
        return new Result(200, null, this.agentTypeService.getAgentTypes(level));
    }
}
