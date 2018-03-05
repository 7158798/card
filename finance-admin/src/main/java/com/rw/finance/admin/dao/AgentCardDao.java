package com.rw.finance.admin.dao;

import com.rw.finance.common.entity.AgentCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentCardDao extends JpaRepository<AgentCard, Long> {
    /**
     * 根据代理编号查询卡片列表
     *
     * @param agentid
     * @param isdeal
     * @return
     */
    List<AgentCard> findAllByAgentidAndIsdel(Long agentid, int isdeal);

    /**
     * 根据银行卡号查询卡片信息
     *
     * @param cardno
     * @return
     */
    AgentCard findByCardno(String cardno);
}
