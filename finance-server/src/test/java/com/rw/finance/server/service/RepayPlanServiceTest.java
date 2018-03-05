package com.rw.finance.server.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rw.finance.common.entity.RepayPlan;
import com.rw.finance.common.service.RepayPlanService;
import com.rw.finance.server.BaseTest;

/**
 * 
 * @file RepayPlanServiceTest.java	
 * @author huanghongfei
 * @date 2018年1月20日 下午5:08:00
 * @declaration
 */
public class RepayPlanServiceTest extends BaseTest{

	@Autowired
	private RepayPlanService repayPlanService;
	
	@Test
	public void all(){
		List<RepayPlan> repayPlans=repayPlanService.listByMemberidAndCardid(8, 9,0,10);
		repayPlans.forEach(repayPlan->{
			System.err.println(repayPlan.getStatus());
		});
	}
}
