package com.rw.finance.server.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rw.finance.common.constants.TimeConstants;
import com.rw.finance.server.BaseTest;

public class BaseCacheServiceTest extends BaseTest{

	@Autowired
	private BaseCacheServiceImpl baseCacheServiceImpl;
	
	@Test
	public void set(){
		baseCacheServiceImpl.set("key", "value",TimeConstants.SMS_CODE_EXPRIE_TIME);
	}
}
