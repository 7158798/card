package com.rw.finance.common.service;

import com.rw.finance.common.entity.AgentInfo;

/**
 * 
 * @file AgentInfoService.java	
 * @author huanghongfei
 * @date 2017年12月26日 下午5:29:28
 * @declaration
 */
public interface AgentInfoService {
	/**
	 * 根据代理编号获取代理信息
	 * @param agentid
	 * @return
	 */
	AgentInfo getByAgentid(long agentid);
}
