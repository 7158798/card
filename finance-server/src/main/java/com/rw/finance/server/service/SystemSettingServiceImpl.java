package com.rw.finance.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.entity.SystemSetting;
import com.rw.finance.common.service.SystemSettingService;
import com.rw.finance.server.dao.SystemSettingDao;
/**
 * 
 * @file SystemSettingServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午6:06:04
 * @declaration
 */
@Component
@Service(interfaceClass=SystemSettingService.class)
public class SystemSettingServiceImpl implements SystemSettingService{

	@Autowired
	private SystemSettingDao systemSettingDao;

	@Cacheable
	@Override
	public SystemSetting getByDictkey(String dictkey) {
		return systemSettingDao.findByDictkey(dictkey);
	}

	@Cacheable
	@Override
	public List<SystemSetting> listByIsapp() {
		return systemSettingDao.findByIsapp(1);
	}

}
