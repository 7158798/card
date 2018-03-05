package com.rw.finance.client.controller;

import java.util.HashSet;
import java.util.List;


import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import com.alibaba.dubbo.config.annotation.Reference;
import com.rw.finance.client.annotation.MemberInfoAuthor;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.entity.MemberLevel;
import com.rw.finance.common.entity.PayChannel;
import com.rw.finance.common.service.MemberInfoService;
import com.rw.finance.common.service.PayChannelService;
import com.rw.finance.common.utils.Result;
/**
 * 
 * @file PayChannelController.java	
 * @author huanghongfei
 * @date 2018年2月1日 下午4:01:17
 * @declaration
 */
@RestController
@RequestMapping(value="/pay/channel")
public class PayChannelController {

	@Reference
	private PayChannelService payChannelService;
	@Reference
	private MemberInfoService memberInfoService;
	/**
	 * 获取可用的渠道列表
	 * @return
	 */
	@MemberInfoAuthor(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/list")
	public Result<Object> list(@RequestAttribute(value="memberid")long memberid){
		List<PayChannel> payChannels=payChannelService.list();
		MemberInfo memberInfo=memberInfoService.getByMemberid(memberid);
		payChannels.forEach(channel->{
			Set<MemberLevel> memberLevels=new HashSet<MemberLevel>();
			for(MemberLevel memberLevel:channel.getMemberLevels()){
				if(memberLevel.getLevel().intValue()==memberInfo.getLevel().intValue()){
					memberLevels.add(memberLevel);
				}
			}
			channel.setMemberLevels(memberLevels);
		});
		return new Result<Object>(200,null,payChannels);
	}
	
}
