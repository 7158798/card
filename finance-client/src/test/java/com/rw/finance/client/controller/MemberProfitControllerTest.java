package com.rw.finance.client.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rw.finance.client.BaseTest;

/**
 * 
 * @file MemberProfitControllerTest.java	
 * @author huanghongfei
 * @date 2017年12月23日 上午11:35:21
 * @declaration
 */
public class MemberProfitControllerTest extends BaseTest{

	@Autowired
	private MemberProfitController memberProfitController;
	
	@Test
	public void countByMemberidGroupLevel(){
		System.err.println(memberProfitController.countByMemberidGroupLevel(31));
	}
}
