package com.rw.finance.admin.service.impl;

import com.rw.finance.admin.dao.AgentTypeDao;
import com.rw.finance.admin.service.AgentTypeService;
import com.rw.finance.common.entity.AgentType;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 代理类型实现
 */
@Service
public class AgentTypeServiceImpl implements AgentTypeService {
    @Autowired
    private AgentTypeDao agentTypeDao;

    @Override
    public AgentType getAgentType(long typeid) {
        return this.agentTypeDao.findOne(typeid);
    }

    @Override
    public List<AgentType> getAgentTypes(int level) {
        if (level > 0) {
            return this.agentTypeDao.findAllByAgentlevelGreaterThan(level);
        }

        return this.agentTypeDao.findAll();
    }

    @Override
    public Result saveAgentType(AgentType model) {
        return null;
    }
}
