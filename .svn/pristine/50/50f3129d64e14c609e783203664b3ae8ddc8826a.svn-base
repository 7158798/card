package com.rw.finance.server.service;

import com.rw.finance.common.entity.OrderInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rw.finance.common.pay.PayerBo;
import com.rw.finance.common.pay.PayerFactory;
import com.rw.finance.common.service.OrderInfoService;
import com.rw.finance.server.BaseTest;

import java.util.List;

/**
 * 
 * @file OrderInfoServiceTest.java	
 * @author huanghongfei
 * @date 2018年1月10日 上午11:02:28
 * @declaration
 */
public class OrderInfoServiceTest extends BaseTest{

	@Autowired
	private OrderInfoService orderInfoService;
	
	//@Test
	public void getByDetailsLike(){
		System.err.println(orderInfoService.getByDetailsLike("\"taskId\":"+631));
	}

	@Test
	public void listByMemberidAndType(){
		List<OrderInfo> orderInfoList=orderInfoService.listByMemberidAndType(29,2,0,10);
		System.out.println(1);
	}
}
