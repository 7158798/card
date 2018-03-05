package com.rw.finance.admin.dao;

import com.rw.finance.common.entity.AgentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentTypeDao extends JpaRepository<AgentType, Long> {
    /**
     * 根据等级查询类型
     *
     * @param level
     * @return
     */
    List<AgentType> findAllByAgentlevelGreaterThan(Integer level);
}
