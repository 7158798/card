package com.rw.finance.admin.service;

import com.rw.finance.admin.model.AgentProfitQueryModel;
import com.rw.finance.admin.model.CountAgentProfitEChartsModel;
import com.rw.finance.common.entity.AgentProfit;
import org.springframework.data.domain.Page;

/**
 * 代理收益
 */
public interface AgentProfitService {
    /**
     * 查询收益记录
     *
     * @param model
     * @return
     */
    Page<AgentProfit> getAgentProfits(AgentProfitQueryModel model);

    /**
     * 统计收益信息
     *
     * @param agentid
     * @param type
     * @return
     */
    CountAgentProfitEChartsModel getProfitCount(Long agentid, String type);
}
