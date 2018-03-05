package com.rw.finance.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.entity.AgentInfo;
import com.rw.finance.common.service.AgentInfoService;
import com.rw.finance.server.dao.AgentInfoDao;
/**
 * 
 * @file AgentInfoServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月26日 下午5:29:11
 * @declaration
 */
@Component
@Service(interfaceClass=AgentInfoService.class)
public class AgentInfoServiceImpl implements AgentInfoService{

	@Autowired
	private AgentInfoDao agentInfoDao;
	
	@Override
	public AgentInfo getByAgentid(long agentid) {
		return agentInfoDao.findOne(agentid);
	}

}
