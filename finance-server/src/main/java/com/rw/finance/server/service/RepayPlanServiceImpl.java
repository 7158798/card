package com.rw.finance.server.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.entity.RepayPlan;
import com.rw.finance.common.service.RepayPlanService;
import com.rw.finance.server.dao.RepayPlanDao;
import com.rw.finance.server.dao.RepayTaskDao;

/**
 * 
 * @file RepayPlanServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月15日 下午1:53:46
 * @declaration
 */
@Component
@Service(interfaceClass=RepayPlanService.class)
public class RepayPlanServiceImpl implements RepayPlanService{
	
	private static Logger log=LoggerFactory.getLogger(RepayPlanService.class);

	@Autowired
	private RepayPlanDao repayPlanDao;
	@Autowired
	private RepayTaskDao repayTaskDao;

	@Override
	public List<RepayPlan> listByMemberidAndCardid(long memberid,long cardid,int page,int size) {
		List<RepayPlan> repayPlans=repayPlanDao.findByMemberidAndCardidOrderByCreatetime(memberid, cardid);
		return repayPlans;
	}
	@Override
	public List<RepayPlan> listByMemberidAndCardidAndStatus(long memberid,long cardid,int status,int page,int size) {
		List<RepayPlan> repayPlans=repayPlanDao.findByMemberidAndCardidAndStatusOrderByCreatetime(memberid, cardid,status,new PageRequest(page, size)).getContent();
		return repayPlans;
	}

	@Override
	public RepayPlan getByMemberidAndPlanid(long memberid,long planid) {
		return repayPlanDao.findByMemberidAndPlanid(memberid, planid);
	}

	@Override
	public RepayPlan getByPlanid(long planid) {
		return repayPlanDao.findOne(planid);
	}

	@Override
	public void update(RepayPlan repayPlan) {
		repayPlanDao.saveAndFlush(repayPlan);
	}

	@Override
	public List<RepayPlan> listByStatus(int status) {
		return repayPlanDao.findByStatus(status);
	}

	
	
}
