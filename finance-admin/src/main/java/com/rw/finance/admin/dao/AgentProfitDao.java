package com.rw.finance.admin.dao;

import com.rw.finance.common.entity.AgentProfit;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AgentProfitDao extends PagingAndSortingRepository<AgentProfit, Long>,
        JpaSpecificationExecutor<AgentProfit> {
    @Query(value = "select sum(amount) from AgentProfit")
    Double sum();

    @Query(value = "select sum(amount) from AgentProfit where agentid = ?1")
    Double sumByAgentid(Long agentid);
}
