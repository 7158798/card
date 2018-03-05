package com.rw.finance.admin.service;

import com.rw.finance.common.entity.AgentCard;
import com.rw.finance.common.utils.Result;

import java.util.List;

/**
 * 代理卡片接口
 */
public interface AgentCardService {
    /**
     * 查询卡片信息
     *
     * @param cardid
     * @return
     */
    AgentCard getAgentCard(Long cardid);

    /**
     * 查询卡片列表
     *
     * @param agentid
     * @return
     */
    List<AgentCard> getAgentCards(Long agentid);

    /**
     * 保存银行卡片
     *
     * @param model
     */
    Result saveAgentCard(AgentCard model);

    /**
     * 删除银行卡片
     *
     * @param cardid
     */
    void delAgentCard(Long cardid);
}
