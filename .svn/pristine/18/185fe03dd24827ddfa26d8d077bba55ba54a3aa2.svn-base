package com.rw.finance.task.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import com.rw.finance.common.constants.RepayPlanConstants;
import com.rw.finance.task.task.RepayPlanTask;

/**
 * 
 * @file RedisConfig.java
 * @author huanghongfei
 * @date 2017年12月20日 上午9:44:49
 * @declaration
 */
@Configuration
public class RedisConfig {

	@Autowired
	private RepayPlanTask repayPlanTask;
	
	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(repayPlanTask, new PatternTopic(RepayPlanConstants.REPAY_PLAN_EXECUTE));
		container.addMessageListener(repayPlanTask, new PatternTopic(RepayPlanConstants.REPAY_PLAN_CANCEL));
		return container;
	}

}
