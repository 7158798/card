package com.rw.finance.common.pay;

import java.io.Serializable;

/**
 * 支付结果类
 * @file PayResult.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午1:10:12
 * @declaration
 */
public class PayResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3477966514801888979L;

	public PayResult(String code,boolean success,String payTradeNo,String tradeNo,String details,int isNeedSms){
		this.code=code;
		this.success=success;
		this.payTradeNo=payTradeNo;
		this.tradeNo=tradeNo;
		this.details=details;
		this.isNeedSms=isNeedSms;
	}
	/**
	 * 状态码
	 */
	private String code;
	/**
	 * 是否成功
	 */
	private boolean success;
	/**
	 * 支付平台流水号
	 */
	private String payTradeNo;
	/**
	 * 商户流水号
	 */
	private String tradeNo;
	/**
	 * 结果详情,易宝支付用于存储支付跳转链接
	 */
	private String details;
	/**
	 * 是否需要短信验证
	 */
	private int isNeedSms;
	/**
	 * 支付结果
	 */
	private String result;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getPayTradeNo() {
		return payTradeNo;
	}
	public void setPayTradeNo(String payTradeNo) {
		this.payTradeNo = payTradeNo;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getIsNeedSms() {
		return isNeedSms;
	}
	public void setIsNeedSms(int isNeedSms) {
		this.isNeedSms = isNeedSms;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
