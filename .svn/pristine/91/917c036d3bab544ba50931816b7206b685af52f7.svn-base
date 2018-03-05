package com.rw.finance.admin.service;

import com.rw.finance.admin.model.CountOrderEChartsModel;
import com.rw.finance.admin.model.OrderInfoQueryModel;
import com.rw.finance.common.entity.OrderInfo;
import org.springframework.data.domain.Page;

/**
 * 订单信息接口
 */
public interface OrderInfoService {
    /**
     * 取得订单列表
     *
     * @param model
     * @return
     */
    Page<OrderInfo> getOrderInfos(OrderInfoQueryModel model);

    /**
     * 统计订单信息
     *
     * @param agentid
     * @param start
     * @param end
     * @return
     */
    CountOrderEChartsModel getOrderCount(Long agentid, String start, String end);
}
