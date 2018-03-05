package com.rw.finance.client.vo;

/**
 * 鉴权数据显示模型
 * @file MemberCardAuthVo.java	
 * @author huanghongfei
 * @date 2017年12月27日 下午4:50:33
 * @declaration
 */
public class MemberCardVo {

	/**
	 * 鉴权显示模型
	 * @file MemberCardVo.java	
	 * @author huanghongfei
	 * @date 2017年12月27日 下午5:26:57
	 * @declaration
	 */
	public class AuthVo{
		public AuthVo(String tradeNo,long cardId,int isNeedSms){
			this.tradeNo=tradeNo;
			this.cardId=cardId;
			this.isNeedSms=isNeedSms;
		}
		private String tradeNo;//支付订单号
		private long cardId;//卡编号
		private int isNeedSms;//是否需要短信验证码
		public String getTradeNo() {
			return tradeNo;
		}
		public void setTradeNo(String tradeNo) {
			this.tradeNo = tradeNo;
		}
		public long getCardId() {
			return cardId;
		}
		public void setCardId(long cardId) {
			this.cardId = cardId;
		}
		public int getIsNeedSms() {
			return isNeedSms;
		}
		public void setIsNeedSms(int isNeedSms) {
			this.isNeedSms = isNeedSms;
		}
	}
	/**
	 * 
	 * @file MemberCardVo.java	
	 * @author huanghongfei
	 * @date 2018年1月4日 上午10:49:06
	 * @declaration
	 */
	public class PayActiveVo{
		/**
		 * 平台流水号
		 */
		private String tradeNo;
		/**
		 * 是否需要短信验证
		 */
		private int isNeedSms;
		/**
		 * 支付跳转地址
		 */
		private String payUrl;

		public String getTradeNo() {
			return tradeNo;
		}

		public void setTradeNo(String tradeNo) {
			this.tradeNo = tradeNo;
		}

		public int getIsNeedSms() {
			return isNeedSms;
		}

		public void setIsNeedSms(int isNeedSms) {
			this.isNeedSms = isNeedSms;
		}

		public String getPayUrl() {
			return payUrl;
		}

		public void setPayUrl(String payUrl) {
			this.payUrl = payUrl;
		}
		
	}
}
