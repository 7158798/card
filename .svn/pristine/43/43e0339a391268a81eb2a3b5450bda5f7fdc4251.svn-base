package com.rw.finance.client.service;

import org.junit.Test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rw.finance.client.BaseTest;
import com.rw.finance.common.service.PayResultService;

public class PayResultServiceTest extends BaseTest{

	@Reference
	private PayResultService payResultService;
	
	@Test
	public void chuangXinPayBack(){
		payResultService.chuangXinPayBack("2201801516425036626836470627251");
	}
}
