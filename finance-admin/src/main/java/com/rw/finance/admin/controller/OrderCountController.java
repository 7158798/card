package com.rw.finance.admin.controller;

/**
 * 统计信息
 */

import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.model.OrderCountQueryModel;
import com.rw.finance.admin.service.OrderCountService;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/count")
public class OrderCountController {
    @Autowired
    private OrderCountService orderCountService;

    @AgentInfoAuthor(level = 0)
    @PostMapping(value = "/getordercounts")
    public Result getOrderCounts(OrderCountQueryModel queryModel) {
        return new Result(200, null, this.orderCountService.getOrderCounts(queryModel));
    }

    @PostMapping(value = "/getprofitcount")
    @AgentInfoAuthor(level = 0)
    public Result getProfitCount(@RequestParam(value = "start", required = true) String start, @RequestParam(value =
            "end", required = true) String end) {
        return new Result(200, null, this.orderCountService.getProfitCount(start, end));
    }
}
