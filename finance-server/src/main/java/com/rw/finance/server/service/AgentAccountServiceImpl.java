package com.rw.finance.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.entity.AgentAccount;
import com.rw.finance.common.service.AgentAccountService;
import com.rw.finance.server.dao.AgentAccountDao;
/**
 * 
 * @file AgentAccountServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月26日 下午8:25:04
 * @declaration
 */
@Component
@Service(interfaceClass=AgentAccountService.class)
public class AgentAccountServiceImpl implements AgentAccountService{
	
	@Autowired
	private AgentAccountDao agentAccountDao;

	@Override
	public AgentAccount getByAgentid(long agentid) {
		return agentAccountDao.findByAgentid(agentid);
	}

	@Override
	public AgentAccount update(AgentAccount agentAccount) {
		agentAccountDao.saveAndFlush(agentAccount);
		return agentAccount;
	}
	
	
	
}
