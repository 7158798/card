package com.rw.finance.client.service;

import org.junit.Test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rw.finance.client.BaseTest;
import com.rw.finance.common.service.BankInfoService;
/**
 * 
 * @file BankInfoServiceTest.java	
 * @author huanghongfei
 * @date 2017年12月15日 下午3:57:59
 * @declaration
 */
public class BankInfoServiceTest extends BaseTest{

	@Reference
	private BankInfoService bankInfoService;
	
	@Test
	public void listTest(){
		System.err.println(bankInfoService.list().get(0).getBankname());
	}
}
