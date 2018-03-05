package com.rw.finance.admin.controller;

import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.model.AgentCashOrderQueryModel;
import com.rw.finance.admin.model.OrderInfoQueryModel;
import com.rw.finance.admin.service.OrderInfoService;
import com.rw.finance.common.entity.OrderInfo;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代理提现
 *
 * @author huanghongfei
 * @file AgentCashOrderController.java
 * @date 2017年12月25日 上午10:29:30
 * @declaration
 */
@RestController
@RequestMapping(value = "/agentcash")
public class AgentCashOrderController {
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 获取提现记录
     *
     * @param query
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getcashorders")
    public Result getCashOrders(AgentCashOrderQueryModel query) {
        // 构造条件
        OrderInfoQueryModel model = new OrderInfoQueryModel();
        BeanUtils.copyProperties(query, model);
        model.setType(4);

        // 提交查询
        Page<OrderInfo> data = orderInfoService.getOrderInfos(model);
        return new Result(200, null, data);
    }

}
