package com.rw.finance.server.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.service.AgentCardService;
/**
 * 
 * @file AgentCardServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月15日 下午2:46:29
 * @declaration
 */
@Component
@Service(interfaceClass=AgentCardService.class)
public class AgentCardServiceImpl implements AgentCardService{

}
