package com.rw.finance.client.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rw.finance.client.annotation.MemberInfoAuthor;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.entity.RepayTask;
import com.rw.finance.common.service.RepayTaskService;
import com.rw.finance.common.utils.MathUtils;
import com.rw.finance.common.utils.Result;
/**
 * 
 * @file RepayTaskController.java	
 * @author huanghongfei
 * @date 2017年12月18日 下午3:11:50
 * @declaration
 */
@RestController
@RequestMapping(value="/repay/task")
public class RepayTaskController {

	@Reference
	private RepayTaskService repayTaskService;
	
	/**
	 * 生成还款计划
	 * @param memberid
	 * @param dates 日期字符串，使用,隔开，例：28,29,30
	 * @param money 还款金额
	 * @return
	 */
	@MemberInfoAuthor(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/generator")
	public Result<Object> generator(@RequestAttribute(value="memberid",required=true)long memberid,
			@RequestParam(value="cardid",required=true)long cardid,
			@RequestParam(value="dates",required=true)String dates,
			@RequestParam(value="money",required=true)double money){
		Map<String,Object> repayPlans=repayTaskService.generator(memberid,cardid, dates, money);
		return new Result<Object>(200,null,repayPlans);
	}
	/**
	 * 获取任务列表
	 * @param memberid
	 * @param planid
	 * @return
	 */
	@MemberInfoAuthor(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/listByPlanid")
	public Result<Object> listByPlanid(@RequestAttribute(value="memberid",required=true)long memberid,
			@RequestParam(value="planid",required=true)long planid){
		List<RepayTask> repayTasks=repayTaskService.listByMemberidAndPlanid(memberid, planid);
		repayTasks.forEach(repayTask->{
			this.persist(repayTask);
		});
		return new Result<Object>(200,null,repayTasks);
	}
	/**
	 * 反射保留double后两位
	 * @param obj
	 * @param clazz
	 * @return
	 */
	private Object persist(Object obj){
		Field[] fields=obj.getClass().getDeclaredFields();
		for(Field field:fields){
			if(field.getType()!=Double.class){
				continue;
			}
			field.setAccessible(true);
			try {
				field.set(obj,MathUtils.persist(Double.parseDouble(field.get(obj).toString()), 2));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
}
