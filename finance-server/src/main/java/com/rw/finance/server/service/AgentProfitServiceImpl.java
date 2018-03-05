package com.rw.finance.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.entity.AgentAccount;
import com.rw.finance.common.entity.AgentProfit;
import com.rw.finance.common.service.AgentProfitService;
import com.rw.finance.common.utils.MathUtils;
import com.rw.finance.server.dao.AgentAccountDao;
import com.rw.finance.server.dao.AgentProfitDao;
/**
 * 
 * @file AgentProfitServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月26日 下午5:55:57
 * @declaration
 */
@Component
@Service(interfaceClass=AgentProfitService.class)
public class AgentProfitServiceImpl implements AgentProfitService{
	
	@Autowired
	private AgentProfitDao agentProfitDao;
	@Autowired
	private AgentAccountDao agentAccountDao;
	
	@Async
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void add(AgentProfit agentProfit) {
		agentProfitDao.save(agentProfit);
		AgentAccount agentAccount=agentAccountDao.findByAgentid(agentProfit.getAgentid());
		//向代理账户加钱
		agentAccount.setUsablebalance(MathUtils.add(agentAccount.getUsablebalance(), agentProfit.getAmount()));
		agentAccountDao.saveAndFlush(agentAccount);
	}

}
