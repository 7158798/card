package com.rw.finance.server.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rw.finance.common.entity.MemberCard;

/**
 * 
 * @file MemberCardDao.java	
 * @author huanghongfei
 * @date 2017年12月12日 下午4:32:07
 * @declaration
 */
public interface MemberCardDao extends JpaRepository<MemberCard,Long>{

	MemberCard findByCardno(String cardno);
	
	MemberCard findByCardnoAndIsdel(String cardno,int isdel);
	
	List<MemberCard> findByMemberidAndTypeAndIsdefAndIsdel(long memberid,int type, int isdef,int isdel);
	
	List<MemberCard> findByMemberidAndTypeAndIsdel(long memberid, int type,int isdel);
	
	MemberCard findByMemberidAndCardid(long memberid,long cardid);
	
	MemberCard findByMemberidAndCardidAndType(long memberid,long cardid,int type);
}
