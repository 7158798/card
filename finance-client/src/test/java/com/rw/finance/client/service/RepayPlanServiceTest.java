package com.rw.finance.client.service;

import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rw.finance.client.BaseTest;
import com.rw.finance.common.service.RepayPlanService;
/**
 * 
 * @file RepayPlanServiceTest.java	
 * @author huanghongfei
 * @date 2017年12月19日 下午5:29:56
 * @declaration
 */
public class RepayPlanServiceTest extends BaseTest{

	@Reference
	private RepayPlanService repayPlanService;
	
	//@Test
	public void current(){
		System.out.println(1);
		repayPlanService.listByMemberidAndCardid(1, 4,0,10);
	}

	
}
