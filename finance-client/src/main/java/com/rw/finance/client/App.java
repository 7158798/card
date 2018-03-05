package com.rw.finance.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author huanghongfei
 * @date 2017年12月7日
 * @declaration
 */
@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean  
    public EmbeddedServletContainerFactory servletContainer() {  
        JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();  
        return factory;  
    }  
}
