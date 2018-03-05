package com.rw.finance.admin.service;

/**
 * 
 * @file BaseCacheService.java	
 * @author huanghongfei
 * @date 2017年12月15日 上午10:21:53
 * @declaration
 */
public interface BaseCacheService {

	void set(String key, Object value, long time);

	Object get(String key, Class<?> clazz);
	
	void remove(String key);
	
}
