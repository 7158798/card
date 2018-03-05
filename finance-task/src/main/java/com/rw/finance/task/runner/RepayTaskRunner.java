package com.rw.finance.task.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.rw.finance.common.constants.RepayPlanConstants;
import com.rw.finance.common.entity.RepayPlan;
import com.rw.finance.task.task.RepayPlanTask;
import com.rw.finance.task.utils.BeanService;
import com.rw.finance.task.utils.SpringUtil;
/**
 * 还款任务启动加载
 * @file RepayTaskRunner.java	
 * @author huanghongfei
 * @date 2017年12月18日 下午2:51:47
 * @declaration
 */
@Component
@Order(value=1)
public class RepayTaskRunner implements CommandLineRunner{

	@Autowired
	private RepayPlanTask repayPlanTask;
	
	@Override
	public void run(String... args) throws Exception {
		List<RepayPlan> repayPlans=SpringUtil.getBean(BeanService.class).repayPlanService.listByStatus(RepayPlanConstants.Status.STATUS1.getStatus());
		repayPlans.forEach(repayPlan->{
			repayPlanTask.execute(repayPlan.getMemberid(), repayPlan.getPlanid());
		});
	}

}
