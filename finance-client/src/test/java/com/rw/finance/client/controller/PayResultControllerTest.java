package com.rw.finance.client.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rw.finance.client.BaseTest;

public class PayResultControllerTest extends BaseTest{

	@Autowired
	private PayResultController payResultController;
	
	@Test
	public void chuangXinBack(){
		String tradeNo="0201801111924447787390621288903";
		payResultController.chuangXinBack(tradeNo,"","");
	}
}
