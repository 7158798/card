package com.rw.finance.server.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rw.finance.common.entity.PayChannel;
import com.rw.finance.common.service.PayChannelService;
import com.rw.finance.server.BaseTest;
/**
 * 
 * @file PayChannelServiceTest.java	
 * @author huanghongfei
 * @date 2018年2月1日 下午5:00:33
 * @declaration
 */
public class PayChannelServiceTest extends BaseTest{

	@Autowired
	private PayChannelService payChannelService;
	
	@Test
	public void list(){
		List<PayChannel> payChannels=payChannelService.list();
		System.err.println(1);
	}
	
}
