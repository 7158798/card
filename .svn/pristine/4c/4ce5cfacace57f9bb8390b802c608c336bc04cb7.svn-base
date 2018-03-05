package com.rw.finance.server.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.constants.MemberCardConstatns;
import com.rw.finance.common.entity.MemberAccount;
import com.rw.finance.common.entity.MemberCard;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.service.MemberInfoService;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.JwtUtil;
import com.rw.finance.common.utils.Md5Util;
import com.rw.finance.server.dao.MemberAccountDao;
import com.rw.finance.server.dao.MemberCardDao;
import com.rw.finance.server.dao.MemberInfoDao;
import com.rw.finance.server.dao.MemberLevelDao;
import com.rw.finance.server.dao.PayChannelDao;
/**
 * 
 * @file MemberInfoServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午1:35:06
 * @declaration
 */
@Component
@Service(interfaceClass=MemberInfoService.class)
public class MemberInfoServiceImpl implements MemberInfoService{

	@Autowired
	private MemberInfoDao memberInfoDao;
	
	@Autowired
	private MemberCardDao memberCardDao;
	
	@Autowired
	private MemberAccountDao memberAccountDao;
	
	@Autowired
	private MemberLevelDao memberLevelDao;
	@Autowired
	private PayChannelDao payChannelDao;
	
	@Override
	public boolean isExistByTelephone(String telephone) {
		MemberInfo memberInfo =memberInfoDao.findByTelephone(telephone);
		if(StringUtils.isEmpty(memberInfo)){
			return false;
		}
		return true;
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void add(MemberInfo memberInfo) {
		memberInfoDao.save(memberInfo);
		memberAccountDao.save(new MemberAccount(memberInfo.getMemberid(), memberLevelDao.findByLevelAndChannelid(memberInfo.getLevel(),payChannelDao.findByIsdef(1).getChannelid()).getRepayrate(), 0, 0, 0, 0));
	}

	public MemberInfo getByTelephone(String telephone) {
		MemberInfo memberInfo =memberInfoDao.findByTelephone(telephone);
		return memberInfo;
	}

	public void update(MemberInfo memberInfo) {
		memberInfoDao.saveAndFlush(memberInfo);
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void isReal(MemberInfo memberInfo, MemberCard memberCard) {
		memberInfoDao.saveAndFlush(memberInfo);
		List<MemberCard> memberCards =memberCardDao.findByMemberidAndTypeAndIsdefAndIsdel(memberCard.getMemberid(),MemberCardConstatns.Type.TYPE1.getType(), 1,0);
		memberCard.setIsdef(memberCards.isEmpty()?1:0);
		memberCard.setStatus(MemberCardConstatns.Status.STATUS1.getStatus());
		memberCardDao.saveAndFlush(memberCard);
	}

	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public String login(String telephone, String password) {
		MemberInfo memberInfo =memberInfoDao.findByTelephoneAndPassword(telephone,Md5Util.md5(password));
		if(StringUtils.isEmpty(memberInfo)){
			return null;
		}
		Map<String,Object> headerParams=new HashMap<String,Object>();//报文头参数列表
		Map<String,Object> bodyParams=new HashMap<String,Object>();//报文body参数列表
		bodyParams.put("memberid", memberInfo.getMemberid());
		bodyParams.put("level", memberInfo.getLevel());
		memberInfo.setLastlogintime(DateUtils.getTimeStr(new Date()));
		memberInfoDao.saveAndFlush(memberInfo);
		return JwtUtil.tokenGenerator(headerParams, bodyParams);
	}

	public MemberInfo getByMemberid(long memberid) {
		return memberInfoDao.findOne(memberid);
	}

	public boolean updPasswordByMemberidAndPassword(long memberid, String password,String newPassword) {
		MemberInfo memberInfo =memberInfoDao.findByMemberidAndPassword(memberid, Md5Util.md5(password));
		if(StringUtils.isEmpty(memberInfo)){
			return false;
		}
		memberInfo.setPassword(Md5Util.md5(newPassword));
		memberInfoDao.saveAndFlush(memberInfo);
		return true;
	}

	public boolean updPaypwdByMemberidAndPaypwd(long memberid, String paypwd,String newPaypwd) {
		MemberInfo memberInfo =memberInfoDao.findByMemberidAndPaypwd(memberid, paypwd);
		if(StringUtils.isEmpty(memberInfo)){
			return false;
		}
		memberInfo.setPaypwd(newPaypwd);
		memberInfoDao.saveAndFlush(memberInfo);
		return true;
	}

	public boolean updPaypwdByMemberid(long memberid, String newPaypwd) {
		MemberInfo memberInfo =memberInfoDao.findOne(memberid);
		if(StringUtils.isEmpty(memberInfo)){
			return false;
		}
		memberInfo.setPaypwd(newPaypwd);
		memberInfoDao.saveAndFlush(memberInfo);
		return true;
	}

	public boolean updTelephoneByMemberid(long memberid,String newTelephone) {
		MemberInfo memberInfo =memberInfoDao.findOne(memberid);
		if(StringUtils.isEmpty(memberInfo)){
			return false;
		}
		memberInfo.setTelephone(newTelephone);
		memberInfoDao.saveAndFlush(memberInfo);
		return true;
	}

	public MemberInfo getByMemberidAndTelephone(long memberid, String telephone) {
		MemberInfo memberInfo =memberInfoDao.findByMemberidAndTelephone(memberid, telephone);
		return memberInfo;
	}

	

	@Override
	public List<MemberInfo> listByParentid(long parentid) {
		return memberInfoDao.findByParentidOrderByRegistertime(parentid);
	}
	
	
}
