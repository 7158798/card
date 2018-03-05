package com.rw.finance.admin.service;

import com.rw.finance.common.entity.AgentType;
import com.rw.finance.common.utils.Result;

import java.util.List;

/**
 * 代理类型接口
 */
public interface AgentTypeService {
    /**
     * 取得类型信息
     *
     * @param typeid
     * @return
     */
    AgentType getAgentType(long typeid);

    /**
     * 取得类型集合
     *
     * @param level
     * @return
     */
    List<AgentType> getAgentTypes(int level);

    /**
     * 保存代理类型
     *
     * @param model
     * @return
     */
    Result saveAgentType(AgentType model);
}
