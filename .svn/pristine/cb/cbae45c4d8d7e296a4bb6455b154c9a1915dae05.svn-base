package com.rw.finance.common.pass.chuangxin;

import java.io.Serializable;

/**
 * 创新支付回调接口返回对象
 * @file BackUrlReturn.java	
 * @author huanghongfei
 * @date 2018年1月9日 下午6:19:25
 * @declaration
 */
public class ChuangXinPayResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -434170321171957844L;
	
	public ChuangXinPayResponse(String merchantNo,String dealResult,String sign){
		this.merchantNo=merchantNo;
		this.dealResult=dealResult;
		this.sign=sign;
	}
	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * 交易结果
	 */
	private String dealResult;
	/**
	 * 签名
	 */
	private String sign;
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getDealResult() {
		return dealResult;
	}
	public void setDealResult(String dealResult) {
		this.dealResult = dealResult;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
