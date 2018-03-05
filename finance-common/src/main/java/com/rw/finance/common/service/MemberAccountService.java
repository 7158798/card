package com.rw.finance.common.service;

import com.rw.finance.common.entity.MemberAccount;
import com.rw.finance.common.pay.PayResult;

/**
 * 
 * @file MemberAccountService.java	
 * @author huanghongfei
 * @date 2017年12月23日 下午3:54:58
 * @declaration
 */
public interface MemberAccountService {
	/**
	 * 根据会员编号获取会员账户
	 * @param memberid
	 * @return
	 */
	MemberAccount getByMemberid(long memberid);
	/**
	 * 更新
	 * @param memberAccount
	 */
	void update(MemberAccount memberAccount);
	/**
	 * 提现
	 * @param memberid
	 * @param amount
	 * @param cardid
	 */
	PayResult outcash(long memberid,double amount,long cardid);
	/**
	 * 套现=收款
	 * @param memberid
	 * @param amount
	 * @param fromcardid
	 * @param tocardid
	 */
	PayResult borrowcash(long memberid,double amount,long fromcardid,long tocardid,long channelid);
}
