package com.rw.finance.server.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.entity.MemberLevel;
import com.rw.finance.common.entity.PayChannel;
import com.rw.finance.common.service.PayChannelService;
import com.rw.finance.server.dao.MemberLevelDao;
import com.rw.finance.server.dao.PayChannelDao;
/**
 * 
 * @file PayChannelServiceImpl.java	
 * @author huanghongfei
 * @date 2018年2月1日 下午3:59:08
 * @declaration
 */
@Component
@Service(interfaceClass=PayChannelService.class)
public class PayChannelServiceImpl implements PayChannelService{

	@Autowired
	private PayChannelDao payChannelDao;
	@Autowired
	private MemberLevelDao memberLevelDao;
	
	@Cacheable
	@Override
	public PayChannel getByIsdef() {
		return payChannelDao.findByIsdef(1);
	}
	
	@Cacheable
	@Override
	public List<PayChannel> list() {
		List<PayChannel> payChannels=payChannelDao.findByIsenable(1);
		for(PayChannel payChannel:payChannels){
			List<MemberLevel> memberLevels=memberLevelDao.findByChannelid(payChannel.getChannelid());
			payChannel.setMemberLevels(new HashSet<MemberLevel>(memberLevels));
		}
		return payChannels;
	}


}
