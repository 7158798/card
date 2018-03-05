package com.rw.finance.admin.service;

import com.rw.finance.admin.model.CountProfitEChartsModel;
import com.rw.finance.admin.model.OrderCountQueryModel;
import com.rw.finance.common.entity.OrderCount;
import org.springframework.data.domain.Page;

public interface OrderCountService {
    /**
     * 取得明细列表
     *
     * @param model
     * @return
     */
    Page<OrderCount> getOrderCounts(OrderCountQueryModel model);

    /**
     * 统计收益信息
     *
     * @param start
     * @param end
     * @return
     */
    CountProfitEChartsModel getProfitCount(String start, String end);
}
