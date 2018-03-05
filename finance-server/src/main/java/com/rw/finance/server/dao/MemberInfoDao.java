package com.rw.finance.server.dao;

import java.util.List;

import com.rw.finance.common.entity.MemberInfo;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * @file MemberInfoDao.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午1:34:57
 * @declaration
 */
public interface MemberInfoDao extends JpaRepository<MemberInfo,Long>{

    MemberInfo findByTelephone(String telephone);
	
	MemberInfo findByTelephoneAndPassword(String telephone, String password);
	
	MemberInfo findByMemberidAndPassword(long memberid, String password);
	
	MemberInfo findByMemberidAndPaypwd(long memberid, String paypwd);
	
	MemberInfo findByMemberidAndTelephone(long memberid, String telephone);
	
	List<MemberInfo> findByParentidOrderByRegistertime(long parentid);

	List<MemberInfo> findByLeveltimeGreaterThan(String curDate);
	
}
