package com.rw.finance.server.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rw.finance.common.entity.SystemSetting;
/**
 * 系统设置
 * @file SystemSettingDao.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午6:03:43
 * @declaration
 */
public interface SystemSettingDao extends JpaRepository<SystemSetting, Long>{

	SystemSetting findByDictkey(String dictkey);
	
	List<SystemSetting> findByIsapp(int isapp);
}
