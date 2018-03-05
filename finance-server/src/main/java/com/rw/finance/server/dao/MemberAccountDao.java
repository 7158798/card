package com.rw.finance.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rw.finance.common.entity.MemberAccount;
/**
 * 
 * @file MemberAccountDao.java	
 * @author huanghongfei
 * @date 2017年12月23日 下午3:58:58
 * @declaration
 */
public interface MemberAccountDao extends JpaRepository<MemberAccount,Long>{

	MemberAccount findByMemberid(long memberid);
}
