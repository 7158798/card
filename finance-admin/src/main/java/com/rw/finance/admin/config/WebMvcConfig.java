package com.rw.finance.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.rw.finance.admin.interceptor.AgentInfoAuthorInterceptor;
import com.rw.finance.admin.interceptor.LogInfoInterceptor;

/**
 * 
 * @file WebMvcConfig.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午6:34:25
 * @declaration
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private LogInfoInterceptor logInfoInterceptor;
	
    @Autowired
    private AgentInfoAuthorInterceptor agentInfoAuthorInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(logInfoInterceptor);
        registry.addInterceptor(agentInfoAuthorInterceptor);
    }

}
