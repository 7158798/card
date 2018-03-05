package com.rw.finance.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.entity.PowerLevel;
import com.rw.finance.common.service.PowerLevelService;
import com.rw.finance.server.dao.PowerLevelDao;

/**
 * 
 * @file PowerLevelServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月26日 下午8:31:07
 * @declaration
 */
@Component
@Service(interfaceClass=PowerLevelService.class)
public class PowerLevelServiceImpl implements PowerLevelService{

	@Autowired
	private PowerLevelDao powerLevelDao;
	
	@Override
	public PowerLevel getByLevelid(long levelid) {
		return powerLevelDao.findOne(levelid);
	}

}
