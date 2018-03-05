package com.rw.finance.admin.service;

import com.rw.finance.admin.model.ActvcodeInfoQueryModel;
import com.rw.finance.admin.model.CountActvcodeEChartsModel;
import com.rw.finance.common.entity.ActvcodeInfo;
import com.rw.finance.common.utils.Result;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 激活码接口
 */
public interface ActvcodeInfoService {
    /**
     * 查询激活码
     *
     * @param model
     * @return
     */
    Page<ActvcodeInfo> getActvcodes(ActvcodeInfoQueryModel model);

    /**
     * 分配激活码
     *
     * @param agentid
     * @param count
     * @param level
     * @param issale
     * @param price
     * @return
     */
    Result saveActvcode(Long agentid, Integer count, Integer level, Integer issale, Double price);

    /**
     * 下放激活码
     * @param fromid
     * @param toid
     * @param count
     * @return
     */
    Result grantActvcode(long fromid, long toid, int count);

    /**
     * 修改使用状态
     *
     * @param activeid
     * @param status
     */
    void updateUseStatus(List<Long> activeid, Integer status);

    /**
     * 修改是否可售
     *
     * @param activeid
     * @param status
     */
    void updateSaleStatus(List<Long> activeid, Integer status);

    /**
     * 取得激活码统计
     *
     * @param agentid
     * @param start
     * @param end
     * @return
     */
    CountActvcodeEChartsModel getActvcodeCount(Long agentid, String start, String end);
}
