package com.rw.finance.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Vector;

/**
 * 
 * @author huanghongfei
 * @date 2017年12月7日
 * @declaration
 */
@SpringBootApplication
@EntityScan(value="com.rw.finance.common.entity")
@EnableTransactionManagement(proxyTargetClass=true)
@EnableAsync(proxyTargetClass=true)
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);
	private static final Vector obj = new Vector();

	public static void main(String[] args) {
		try {
			SpringApplication.run(App.class, args);
			synchronized (obj) {
				obj.wait();
			}
			obj.notify();
		} catch (Exception e) {
			log.error("启动Server异常：", e);
		}
	}
	
}
