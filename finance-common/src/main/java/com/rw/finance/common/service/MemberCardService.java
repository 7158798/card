package com.rw.finance.common.service;

import java.util.List;

import com.rw.finance.common.entity.MemberCard;

public interface MemberCardService {

	/**
	 * 添加借记卡
	 * @param memberCard
	 * @return
	 */
	boolean add(MemberCard memberCard);
	/**
	 * 将储蓄卡设为默认卡，只能是储蓄卡
	 * @param memberid
	 * @param cardid
	 */
	void isdef(long memberid,long cardid);
	/**
	 * 添加贷记卡
	 * @param memberCard
	 * @return
	 */
	MemberCard add1(MemberCard memberCard);
	/**
	 * 根据卡号验证卡片是否存在
	 * @param cardno
	 * @return
	 */
	boolean isExsit(String cardno);
	/**
	 * 根据用户编号和类型获取银行卡列表
	 * @param useid
	 * @param type
	 * @return
	 */
	List<MemberCard> listByMemberidAndType(long memberid, int type);
	/**
	 * 根据用户编号和卡片编号获取卡片
	 * @param memberid
	 * @param cardid
	 * @return
	 */
	MemberCard getByMemberidAndCardid(long memberid,long cardid);
	/**
	 * 修改
	 * @param memberCard
	 */
	void update(MemberCard memberCard);
	/**
	 * 根据会员编号和卡片编号和卡片类型获取卡片
	 * @param memberid
	 * @param cardid
	 * @param type
	 * @return
	 */
	MemberCard getByMemberidAndCardidAndType(long memberid,long cardid,int type);
	/**
	 * 根据会员编号和卡片编号删除
	 * @param memberid
	 * @param cardid
	 */
	void delByMemberidAndCardid(long memberid,long cardid);
}
