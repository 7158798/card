package com.rw.finance.admin.service;

import com.rw.finance.admin.model.AgentCashOrderQueryModel;
import com.rw.finance.common.entity.order.AgentCashOrder;

import org.springframework.data.domain.Page;

/**
 * 代理提现记录
 *
 * @author huanghongfei
 * @file AgentCashOrderService.java
 * @date 2017年12月25日 上午10:28:06
 * @declaration
 */
public interface AgentCashOrderService {
    /**
     * 查询提现记录
     *
     * @param model
     * @return
     */
    Page<AgentCashOrder> getCashOrders(AgentCashOrderQueryModel model);
}
