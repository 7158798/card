package com.rw.finance.server.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rw.finance.common.service.MemberAccountService;
import com.rw.finance.server.BaseTest;
/**
 * 
 * @file MemberAccountServiceTest.java	
 * @author huanghongfei
 * @date 2018年1月15日 下午7:21:44
 * @declaration
 */
public class MemberAccountServiceTest extends BaseTest{

	@Autowired
	private MemberAccountService memberAccountService;
	
	//@Test
	public void outcash(){
		memberAccountService.outcash(29,50.49,32);
	}

	@Test
	public void borrow(){
		memberAccountService.borrowcash(29,1,30,32,2);
	}
}
