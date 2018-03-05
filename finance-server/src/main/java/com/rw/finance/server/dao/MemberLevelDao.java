package com.rw.finance.server.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rw.finance.common.entity.MemberLevel;
/**
 * 
 * @file MemberLevelDao.java	
 * @author huanghongfei
 * @date 2017年12月18日 下午3:46:18
 * @declaration
 */
public interface MemberLevelDao extends JpaRepository<MemberLevel, Long>{

	MemberLevel findByLevelAndChannelid(int level,long channelid);
	
	List<MemberLevel> findByChannelid(long channelid);
	
}
