package com.rw.finance.task.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @file SystemTimeListenner.java	
 * @author huanghongfei
 * @date 2018年1月22日 下午3:35:21
 * @declaration
 */
@Component
@Order(value=2)
public class SystemTimeListenner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
	}

}
