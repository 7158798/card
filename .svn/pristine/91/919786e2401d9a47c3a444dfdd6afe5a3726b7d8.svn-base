package com.rw.finance.server.service;

import java.util.Calendar;
import java.util.List;

import com.rw.finance.common.entity.MemberCard;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.constants.MemberCardConstatns;
import com.rw.finance.common.service.MemberCardService;
import com.rw.finance.server.dao.MemberCardDao;

@Component
@Service(interfaceClass=MemberCardService.class)
public class MemberCardServiceImpl implements MemberCardService{

	@Autowired
	private MemberCardDao memberCardDao;
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean add(MemberCard memberCard) {
		List<MemberCard> memberCards =memberCardDao.findByMemberidAndTypeAndIsdefAndIsdel(memberCard.getMemberid(),MemberCardConstatns.Type.TYPE1.getType(), 1,0);
		MemberCard existMemberCard=memberCardDao.findByCardno(memberCard.getCardno());
		if(existMemberCard!=null){
			existMemberCard.setIsdel(0);
			memberCardDao.saveAndFlush(existMemberCard);
			return true;
		}
		memberCard.setIsdef(memberCards.isEmpty()?1:0);
		memberCardDao.save(memberCard);
		return true;
	}
	
	@Async
	@Override
	public void isdef(long memberid, long cardid) {
		List<MemberCard> memberCards=memberCardDao.findByMemberidAndTypeAndIsdel(memberid, MemberCardConstatns.Type.TYPE1.getType(), 0);
		memberCards.forEach(memberCard->{
			memberCard.setIsdef(0);
			if(memberCard.getCardid().longValue()==cardid){
				memberCard.setIsdef(1);
			}
		});
		memberCardDao.save(memberCards);
	}
	
	@Override
	public boolean isExsit(String cardno) {
		if(!StringUtils.isEmpty(memberCardDao.findByCardnoAndIsdel(cardno,0))){
			return true;
		}
		return false;
	}

	@Override
	public List<MemberCard> listByMemberidAndType(long memberid, int type) {
		List<MemberCard> memberCards =memberCardDao.findByMemberidAndTypeAndIsdel(memberid, type,0);
		if(type==MemberCardConstatns.Type.TYPE2.getType()){//如果是贷记卡，计算今日到账单日和今日到还款日的天数
			Calendar today=Calendar.getInstance();
			memberCards.forEach(memberCard->{
				Calendar toDate=Calendar.getInstance();
				toDate.set(Calendar.DATE,Integer.valueOf(memberCard.getBilldate()));
				memberCard.setToBillDate(toDate.get(Calendar.DAY_OF_YEAR)-today.get(Calendar.DAY_OF_YEAR));//今天至账单日天数
				toDate.set(Calendar.DATE,Integer.valueOf(memberCard.getRepaydate()));
				memberCard.setToRepayDate(toDate.get(Calendar.DAY_OF_YEAR)-today.get(Calendar.DAY_OF_YEAR));//今天至还款日天数
			});
		}
		return memberCards;
	}

	@Override
	public MemberCard add1(MemberCard memberCard) {
		MemberCard existMemberCard=memberCardDao.findByCardno(memberCard.getCardno());
		if(existMemberCard!=null){
			existMemberCard.setIsdel(0);
			memberCardDao.saveAndFlush(existMemberCard);
			return existMemberCard;
		}
		memberCardDao.save(memberCard);
		return memberCard;
	}

	@Override
	public MemberCard getByMemberidAndCardid(long memberid, long cardid) {
		return memberCardDao.findByMemberidAndCardid(memberid, cardid);
	}

	@Override
	public void update(MemberCard memberCard) {
		memberCardDao.saveAndFlush(memberCard);
	}

	@Override
	public MemberCard getByMemberidAndCardidAndType(long memberid, long cardid,int type) {
		return memberCardDao.findByMemberidAndCardidAndType(memberid, cardid, type);
	}
	@Override
	public void delByMemberidAndCardid(long memberid, long cardid) {
		MemberCard memberCard=memberCardDao.findByMemberidAndCardid(memberid, cardid);
		if(StringUtils.isEmpty(memberCard)){
			return;
		}
		memberCard.setIsdel(1);
		memberCardDao.saveAndFlush(memberCard);
	}
	

	
}
