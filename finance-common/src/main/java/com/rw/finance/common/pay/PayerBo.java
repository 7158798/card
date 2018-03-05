package com.rw.finance.common.pay;

/**
 * 支付工厂业务模型
 * @file PayerBo.java	
 * @author huanghongfei
 * @date 2018年1月2日 下午2:23:09
 * @declaration
 */
public class PayerBo {

	/**
	 * 用户信息
	 * @file PayerBo.java	
	 * @author huanghongfei
	 * @date 2018年1月2日 下午2:23:49
	 * @declaration
	 */
	public class UserInfo{
		/**
		 * 支付者信息
		 * @param payerIdNo
		 * @param payerRealName
		 */
		public UserInfo(String payerIdNo,String payerRealName){
			this.payerIdNo=payerIdNo;
			this.payerRealName=payerRealName;
		}
		/**
		 * 支付者和收款者信息
		 * @param payerIdNo
		 * @param payerRealName
		 * @param payeeIdNo
		 * @param payeeRealName
		 */
		public UserInfo(String payerIdNo,String payerRealName,String payeeIdNo,String payeeRealName){
			this.payerIdNo=payerIdNo;
			this.payerRealName=payerRealName;
			this.payeeIdNo=payeeIdNo;
			this.payeeRealName=payeeRealName;
		}
		/**
		 * 支付者证号码
		 */
		private String payerIdNo;
		/**
		 * 支付者真实姓名
		 */
		private String payerRealName;
		/**
		 * 收款者证件ID
		 */
		private String payeeIdNo;
		/**
		 * 收款者真实姓名
		 */
		private String payeeRealName;
		public String getPayerIdNo() {
			return payerIdNo;
		}
		public void setPayerIdNo(String payerIdNo) {
			this.payerIdNo = payerIdNo;
		}
		public String getPayerRealName() {
			return payerRealName;
		}
		public void setPayerRealName(String payerRealName) {
			this.payerRealName = payerRealName;
		}
		public String getPayeeIdNo() {
			return payeeIdNo;
		}
		public void setPayeeIdNo(String payeeIdNo) {
			this.payeeIdNo = payeeIdNo;
		}
		public String getPayeeRealName() {
			return payeeRealName;
		}
		public void setPayeeRealName(String payeeRealName) {
			this.payeeRealName = payeeRealName;
		}
	}
	/**
	 * 银行卡信息
	 * @file PayerBo.java	
	 * @author huanghongfei
	 * @date 2018年1月2日 下午2:24:04
	 * @declaration
	 */
	public class CardInfo{
		/**
		 * 银行卡信息
		 * @param payerBankName
		 * @param payerCardNo
		 * @param payerCardMobile
		 * @param payerCardCvv2
		 */
		public CardInfo(String payerBankName,String payerBankProvince,String payerBankCity,String payerBankAbbreviation,String payerCardNo,String payerCardMobile,String payerCardCvv2,String payerCardExpire){
			this.payerBankName=payerBankName;
			this.payerBankProvince=payerBankProvince;
			this.payerBankCity=payerBankCity;
			this.payerBankAbbreviation=payerBankAbbreviation;
			this.payerCardNo=payerCardNo;
			this.payerCardMobile=payerCardMobile;
			this.payerCardCvv2=payerCardCvv2;
			this.payerCardExpire=payerCardExpire;
		}
		/**
		 * 支付者银行卡信息和收款者银行卡信息
		 * @param payerBankName
		 * @param payerCardNo
		 * @param payerCardMobile
		 * @param payerCardCvv2
		 * @param payeeCardNo
		 */
		public CardInfo(String payerBankName,String payerBankProvince,String payerBankCity,String payerBankAbbreviation,String payerCardNo,String payerCardMobile,String payerCardCvv2,String payerCardExpire,String payeeCardNo){
			this.payerBankName=payerBankName;
			this.payerBankProvince=payerBankProvince;
			this.payerBankCity=payerBankCity;
			this.payerBankAbbreviation=payerBankAbbreviation;
			this.payerCardNo=payerCardNo;
			this.payerCardMobile=payerCardMobile;
			this.payerCardCvv2=payerCardCvv2;
			this.payerCardExpire=payerCardExpire;
			this.payeeCardNo=payeeCardNo;
		}
		/**
		 * 银行名称
		 */
		private String payerBankName;
		/**
		 * 省份
		 */
		private String payerBankProvince;
		/**
		 * 市区
		 */
		private String payerBankCity;
		/**
		 * 银行缩写
		 */
		private String payerBankAbbreviation;
		/**
		 * 银行卡号
		 */
		private String payerCardNo;
		/**
		 * 银行编号
		 */
		private String payerBankNo;
		/**
		 * 预留电话
		 */
		private String payerCardMobile;
		/**
		 * 安全码
		 */
		private String payerCardCvv2;
		/**
		 *卡片有效期
		 */
		private String payerCardExpire;
		/**
		 * 收款者卡号
		 */
		private String payeeCardNo;
		/**
		 * 收款者银行缩写
		 */
		private String payeeBankAbbreviation;
		public String getPayerBankName() {
			return payerBankName;
		}
		public void setPayerBankName(String payerBankName) {
			this.payerBankName = payerBankName;
		}
		public String getPayerBankProvince() {
			return payerBankProvince;
		}
		public void setPayerBankProvince(String payerBankProvince) {
			this.payerBankProvince = payerBankProvince;
		}
		public String getPayerBankCity() {
			return payerBankCity;
		}
		public void setPayerBankCity(String payerBankCity) {
			this.payerBankCity = payerBankCity;
		}
		public String getPayerBankAbbreviation() {
			return payerBankAbbreviation;
		}
		public void setPayerBankAbbreviation(String payerBankAbbreviation) {
			this.payerBankAbbreviation = payerBankAbbreviation;
		}
		public String getPayerCardNo() {
			return payerCardNo;
		}
		public void setPayerCardNo(String payerCardNo) {
			this.payerCardNo = payerCardNo;
		}
		public String getPayerBankNo() {
			return payerBankNo;
		}
		public void setPayerBankNo(String payerBankNo) {
			this.payerBankNo = payerBankNo;
		}
		public String getPayerCardMobile() {
			return payerCardMobile;
		}
		public void setPayerCardMobile(String payerCardMobile) {
			this.payerCardMobile = payerCardMobile;
		}
		public String getPayerCardCvv2() {
			return payerCardCvv2;
		}
		public void setPayerCardCvv2(String payerCardCvv2) {
			this.payerCardCvv2 = payerCardCvv2;
		}
		public String getPayerCardExpire() {
			return payerCardExpire;
		}
		public void setPayerCardExpire(String payerCardExpire) {
			this.payerCardExpire = payerCardExpire;
		}
		public String getPayeeCardNo() {
			return payeeCardNo;
		}
		public void setPayeeCardNo(String payeeCardNo) {
			this.payeeCardNo = payeeCardNo;
		}

		public String getPayeeBankAbbreviation() {
			return payeeBankAbbreviation;
		}

		public void setPayeeBankAbbreviation(String payeeBankAbbreviation) {
			this.payeeBankAbbreviation = payeeBankAbbreviation;
		}
	}
	/**
	 * 订单信息
	 * @file PayerBo.java	
	 * @author huanghongfei
	 * @date 2018年1月2日 下午2:24:37
	 * @declaration
	 */
	public class OrderInfo{
		/**
		 * 订单信息
		 * @param tradeNo
		 * @param payTradeNo
		 * @param bizAmount
		 * @param smsCode
		 */
		public OrderInfo(String tradeNo,String payTradeNo,double bizAmount,String backUrl,String smsCode){
			this.tradeNo=tradeNo;
			this.payTradeNo=payTradeNo;
			this.bizAmount=bizAmount;
			this.backUrl=backUrl;
			this.smsCode=smsCode;
		}
		/**
		 * 交易流水号
		 */
		private String tradeNo;
		/**
		 * 支付订单号
		 */
		private String payTradeNo;
		/**
		 * 金额
		 */
		private double bizAmount;
		/**
		 * 短信验证码
		 */
		private String smsCode;
		/**
		 * 后端回调地址
		 */
		private String backUrl;
		/**\
		 * 前端回调
		 */
		private String beforeBackUrl;
		private ProductInfo productInfo=new ProductInfo();
		public class ProductInfo{
			private String name;
			private String details;
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getDetails() {
				return details;
			}
			public void setDetails(String details) {
				this.details = details;
			}
		}
		/**
		 * 备注（还款时用来传递扣款的任务订单编号，用,分割）
		 */
		private String remark;
		public String getTradeNo() {
			return tradeNo;
		}
		public void setTradeNo(String tradeNo) {
			this.tradeNo = tradeNo;
		}
		public String getPayTradeNo() {
			return payTradeNo;
		}
		public void setPayTradeNo(String payTradeNo) {
			this.payTradeNo = payTradeNo;
		}
		public double getBizAmount() {
			return bizAmount;
		}
		public void setBizAmount(double bizAmount) {
			this.bizAmount = bizAmount;
		}
		public String getSmsCode() {
			return smsCode;
		}
		public void setSmsCode(String smsCode) {
			this.smsCode = smsCode;
		}
		public String getBackUrl() {
			return backUrl;
		}
		public void setBackUrl(String backUrl) {
			this.backUrl = backUrl;
		}

		public String getBeforeBackUrl() {
			return beforeBackUrl;
		}
		public void setBeforeBackUrl(String beforeBackUrl) {
			this.beforeBackUrl = beforeBackUrl;
		}
		public ProductInfo getProductInfo() {
			return productInfo;
		}
		public void setProductInfo(ProductInfo productInfo) {
			this.productInfo = productInfo;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
	}
	/**
	 * 支付信息，用于存储支付宝微信特有信息
	 * @file PayerBo.java	
	 * @author huanghongfei
	 * @date 2018年1月29日 上午9:33:59
	 * @declaration
	 */
	public class PayInfo{
		
		public PayInfo(String method,String appId,String openId){
			this.method=method;
			this.appId=appId;
			this.openId=openId;
		}
		/**
		 * 支付方式
		 */
		private String method;
		/**
		 * appId
		 */
		private String appId;
		/**
		 * 微信openId
		 */
		private String openId;
		public String getMethod() {
			return method;
		}
		public void setMethod(String method) {
			this.method = method;
		}
		public String getAppId() {
			return appId;
		}
		public void setAppId(String appId) {
			this.appId = appId;
		}
		public String getOpenId() {
			return openId;
		}
		public void setOpenId(String openId) {
			this.openId = openId;
		}
	}
}
