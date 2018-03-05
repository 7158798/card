package com.rw.finance.server.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.rw.finance.common.service.BaseCacheService;
/**
 * 
 * @file BaseCacheServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月15日 上午10:24:43
 * @declaration
 */
@Component
@Service(interfaceClass=BaseCacheService.class)
public class BaseCacheServiceImpl implements BaseCacheService{

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public void set(String key, Object value,long time) {
		if(StringUtils.isEmpty(value)){
			return;
		}
		stringRedisTemplate.opsForValue().set(key,new Gson().toJson(value),time,TimeUnit.SECONDS);
	}

	@Override
	public Object get(String key,Class<?> clazz) {
		String value=stringRedisTemplate.opsForValue().get(key);
		if(StringUtils.isEmpty(value)){
			return null;
		}
		return new Gson().fromJson(value, clazz);
	}

	@Override
	public void remove(String key) {
		stringRedisTemplate.delete(key);
	}

	@Override
	public long incr(String key) {
		return stringRedisTemplate.boundHashOps("synchronization").increment(key,1L);
	}

}
