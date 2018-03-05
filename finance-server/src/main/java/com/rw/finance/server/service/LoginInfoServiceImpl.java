package com.rw.finance.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.entity.LoginInfo;
import com.rw.finance.common.service.LoginInfoService;
import com.rw.finance.server.dao.LoginInfoDao;
/**
 * 
 * @file LoginInfoServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月23日 下午6:22:53
 * @declaration
 */
@Component
@Service(interfaceClass=LoginInfoService.class)
public class LoginInfoServiceImpl implements LoginInfoService{

	@Autowired
	private LoginInfoDao loginInfoDao;
	
	@Async
	@Override
	public void add(LoginInfo loginInfo) {
		loginInfoDao.save(loginInfo);
	}
}
