package com.rw.finance.client.service;

import org.junit.Test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rw.finance.client.BaseTest;
import com.rw.finance.common.service.MemberProfitService;
/**
 * 
 * @file MemberProfitServiceTest.java	
 * @author huanghongfei
 * @date 2018年2月3日 下午2:29:22
 * @declaration
 */
public class MemberProfitServiceTest extends BaseTest{

	@Reference
	private MemberProfitService memberProfitService;
	
	@Test
	public void listByMemberdid(){
		memberProfitService.listByMemberid(30, 0, 1000);
	}
	
}
