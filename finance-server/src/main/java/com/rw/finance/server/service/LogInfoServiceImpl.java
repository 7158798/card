package com.rw.finance.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.entity.LogInfo;
import com.rw.finance.common.service.LogInfoService;
import com.rw.finance.server.dao.LogInfoDao;

/**
 * 
 * @file LogInfoServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月14日 上午11:51:10
 * @declaration
 */
@Component
@Service(interfaceClass=LogInfoService.class)
public class LogInfoServiceImpl implements LogInfoService{

	@Autowired
	private LogInfoDao logInfoDao;
	
	@Async
	@Override
	public void add(LogInfo logInfo) {
		logInfoDao.save(logInfo);
	}

	
}
