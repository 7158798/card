package com.rw.finance.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.entity.MemberLevel;
import com.rw.finance.common.service.MemberLevelService;
import com.rw.finance.server.dao.MemberLevelDao;

@Component
@Service(interfaceClass=MemberLevelService.class)
public class MemberLevelServiceImpl implements MemberLevelService{

	@Autowired
	private MemberLevelDao memberLevelDao;
	
	@Cacheable
	@Override
	public MemberLevel getByLevelAndChannelid(int level,long channelid) {
		return memberLevelDao.findByLevelAndChannelid(level, channelid);
	}

}
