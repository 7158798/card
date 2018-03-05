package com.rw.finance.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.entity.MemberAccount;
import com.rw.finance.common.entity.MemberProfit;
import com.rw.finance.common.service.MemberProfitService;
import com.rw.finance.common.utils.MathUtils;
import com.rw.finance.server.dao.MemberAccountDao;
import com.rw.finance.server.dao.MemberInfoDao;
import com.rw.finance.server.dao.MemberProfitDao;
/**
 * 
 * @file MemberProfitServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午4:47:19
 * @declaration
 */
@Component
@Service(interfaceClass=MemberProfitService.class)
public class MemberProfitServiceImpl implements MemberProfitService{

	@Autowired
	private MemberProfitDao memberProfitDao;
	@Autowired
	private MemberAccountDao memberAccountDao;
	@Autowired
	private MemberInfoDao memberInfoDao;
	
	@Async
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void add(MemberProfit memberProfit) {
		memberProfitDao.save(memberProfit);
		MemberAccount memberAccount=memberAccountDao.findByMemberid(memberProfit.getMemberid());
		memberAccount.setCashtotal(MathUtils.add(memberAccount.getCashtotal(), memberProfit.getAmount()));//收款总额
		memberAccount.setUsablebalance(MathUtils.add(memberAccount.getUsablebalance(), memberProfit.getAmount()));//可用余额
		memberAccountDao.saveAndFlush(memberAccount);
	}

	@Override
	public List<MemberProfit> listByMemberidAndLevel(long memberid, int level,int page,int size) {
		return memberProfitDao.findByMemberidAndLevelOrderByCreatetime(memberid, level,new PageRequest(page, size)).getContent();
	}


	@Override
	public List<MemberProfit> listByMemberid(long memberid,int page,int size) {
		return memberProfitDao.findByMemberid(memberid,new PageRequest(page, size)).getContent();
	}

	
	@Override
	public List<Object[]> countByMemberidGroupLevel(long memberid) {
		return memberProfitDao.sumAmountAndBizamountCountPromemberidByMemberidGroupByLevel(memberid);
	}

	@Override
	public double sumProfitByMemberidAndDate(long memberid, String date) {
		return memberProfitDao.sumAmountByMemberidAndCreatetimeLikeDate(memberid, date);
	}

	@Override
	public double sumProfitByMemberidAndMonth(long memberid, String month) {
		return memberProfitDao.sumAmountByMemberidAndCreatetimeLikeMonth(memberid, month);
	}

	@Override
	public double sumProfitByMemberid(long memberid) {
		return memberProfitDao.sumAmountByMemberid(memberid);
	}

}
