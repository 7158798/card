package com.rw.finance.admin.service.impl;

import com.google.gson.Gson;
import com.rw.finance.admin.service.BaseCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author huanghongfei
 * @file BaseCacheServiceImpl.java
 * @date 2017年12月15日 上午10:24:43
 * @declaration
 */
@Service
public class BaseCacheServiceImpl implements BaseCacheService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, Object value, long time) {
        stringRedisTemplate.opsForValue().set(key, new Gson().toJson(value), time, TimeUnit.SECONDS);
    }

    @Override
    public Object get(String key, Class<?> clazz) {
        return new Gson().fromJson(stringRedisTemplate.opsForValue().get(key), clazz);
    }

    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }
}
