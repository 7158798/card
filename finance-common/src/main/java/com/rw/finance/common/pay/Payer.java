package com.rw.finance.common.pay;

import com.rw.finance.common.pay.PayerBo.CardInfo;
import com.rw.finance.common.pay.PayerBo.OrderInfo;
import com.rw.finance.common.pay.PayerBo.UserInfo;
/**
 * 
 * @file Payer.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午1:13:06
 * @declaration
 */
public interface Payer {
	/**
	 * 获取回调地址
	 * @return
	 */
	String getBackUrl();
	/**
	 * 银行卡三元认证
	 * @param OrderInfo.tradeNo 系统流水号
	 * @param UserInfo.idRealName 真是姓名
	 * @param UserInfo.idNo 证件号码
	 * @param CardInfo.cardNo 卡号
	 * @return PayResult.class
	 */
	PayResult auth(UserInfo userInfo,CardInfo cardInfo,OrderInfo orderInfo);
	/**
	 * 用户支付给公司
	 * @param OrderInfo.tradeNo 系统流水号
	 * @param UserInfo.idNo 身份证号码
	 * @param UserInfo.idRealName 身份证真实姓名
	 * @param CardInfo.bankName 银行名称
	 * @param CardInfo.cardNo 银行卡号
	 * @param CardInfo.moible 预留电话
	 * @param CardInfo.cvv2  安全码
	 * @param OrderInfo.amount 支付金额,单位(元)
	 * @return PayResult.class
	 */
	PayResult pay(UserInfo userInfo,CardInfo cardInfo,OrderInfo orderInfo);
	/**
	 * 确认支付
	 * @param OrderInfo.payTradeNo 支付订单号
	 * @param OrderInfo.smsCode 短信验证码
	 * @return PayResult.class
	 */
	PayResult confirm(OrderInfo orderInfo);
	/**
	 * 重发验证码
	 * @param orderInfo
	 * @return
	 */
	PayResult reSendSms(OrderInfo orderInfo);
	/**
	 * 公司支付给用户
	 * @param OrderInfo.tradeNo 系统流水号
	 * @param UserInfo.idNo 身份证号码
	 * @param UserInfo.idRealName 身份证真实姓名
	 * @param CardInfo.bankName 银行名称
	 * @param CardInfo.cardNo 银行卡号
	 * @param CardInfo.moible 预留电话
	 * @param CardInfo.cvv2  安全码
	 * @param OrderInfo.amount 支付金额,单位(元)
	 * @return PayResult.class
	 */
	PayResult repay(UserInfo userInfo,CardInfo cardInfo,OrderInfo orderInfo);
	/**
	 * 代理公司支付给用户
	 * @param userInfo
	 * @param cardInfo
	 * @param orderInfo
	 * @return
	 */
	PayResult agentPay(UserInfo userInfo,CardInfo cardInfo,OrderInfo orderInfo);
	/**
	 * 查询支付订单	
	 * @param OrderInfo.payTradeNo 支付号
	 * @return PayResult.class
	 */
	PayResult queryOrder(OrderInfo orderInfo);
	
}
