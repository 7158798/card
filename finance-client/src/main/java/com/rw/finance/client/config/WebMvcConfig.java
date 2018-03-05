package com.rw.finance.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.rw.finance.client.interceptor.LoginInfoInterceptor;
import com.rw.finance.client.interceptor.MemberInfoAuthorInterceptor;
import com.rw.finance.client.interceptor.LogInfoInterceptor;
import com.rw.finance.client.interceptor.VisitFrequencyInterceptor;

/**
 * 
 * @file WebMvcConfig.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午1:18:51
 * @declaration
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private VisitFrequencyInterceptor visitFrequencyInterceptor;

	@Autowired
	private LogInfoInterceptor logInfoInterceptor;
	
    @Autowired
    private MemberInfoAuthorInterceptor MemberInfoAuthorInterceptor;
    
    @Autowired
    private LoginInfoInterceptor loginInfoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	//registry.addInterceptor(visitFrequencyInterceptor);
    	registry.addInterceptor(logInfoInterceptor);
    	registry.addInterceptor(loginInfoInterceptor);
        registry.addInterceptor(MemberInfoAuthorInterceptor);
    }

}
