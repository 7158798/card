package com.rw.finance.common.service;

import com.rw.finance.common.entity.AgentAccount;

/**
 * 
 * @file AgentAccountService.java	
 * @author huanghongfei
 * @date 2017年12月26日 下午8:24:08
 * @declaration
 */
public interface AgentAccountService {
	/**
	 * 
	 * @param agentid
	 * @return
	 */
	AgentAccount getByAgentid(long agentid);
	/**
	 * 更新
	 * @param agentAccount
	 */
	AgentAccount update(AgentAccount agentAccount);
}
