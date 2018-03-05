package com.rw.finance.admin.controller;

import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.model.OrderInfoQueryModel;
import com.rw.finance.admin.service.OrderInfoService;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单信息
 */
@RestController
@RequestMapping(value = "/order")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getorderinfos")
    public Result getOrderInfos(OrderInfoQueryModel queryModel) {
        return new Result(200, null, this.orderInfoService.getOrderInfos(queryModel));
    }

    @PostMapping(value = "/getordercount")
    @AgentInfoAuthor(level = 99)
    public Result getOrderCount(@RequestAttribute(value = "agentid", required = true) Long agentid, @RequestParam
            (value = "start", required = true) String start, @RequestParam(value = "end", required = true) String end) {
        return new Result(200, null, this.orderInfoService.getOrderCount(agentid, start, end));
    }
}
