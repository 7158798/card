package com.rw.finance.common.entity.order;
/**
 * 添加贷记卡支付用于鉴权的订单
 * @file MemberCardOrder.java	
 * @author huanghongfei
 * @date 2018年1月12日 下午4:31:31
 * @declaration
 */
public class MemberCardOrder {

	public MemberCardOrder(long cardId){
		this.cardId=cardId;
	}
	/**
	 * 贷记卡编号
	 */
	private long cardId;
	public long getCardId() {
		return cardId;
	}
	public void setCardId(long cardId) {
		this.cardId = cardId;
	}
}
