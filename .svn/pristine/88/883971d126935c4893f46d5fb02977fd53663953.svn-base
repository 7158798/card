package com.rw.finance.server.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.rw.finance.common.constants.TimeConstants;
import com.rw.finance.common.entity.SystemSetting;
import com.rw.finance.common.service.BaseCacheService;
import com.rw.finance.server.dao.SystemSettingDao;

/**
 * 系统设置缓存启动加载
 * @file SystemSettingCacheRunner.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午6:23:40
 * @declaration
 */
@Component
public class SystemSettingRunner implements CommandLineRunner{

	@Autowired
	private SystemSettingDao systemSettingDao;
	
	@Autowired
	private BaseCacheService baseCacheService;
	
	@Override
	public void run(String... args) throws Exception {
		List<SystemSetting> systemSettings=systemSettingDao.findAll();
		systemSettings.forEach(systemSetting->{
			baseCacheService.set(systemSetting.getDictkey(), systemSetting.getDictval(),TimeConstants.SYSTEM_SETTING_EXPRIE_TIME);
		});
	}
}
