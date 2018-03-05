package com.rw.finance.common.pay;

import com.rw.finance.common.pay.PayerBo.CardInfo;
import com.rw.finance.common.pay.PayerBo.OrderInfo;
import com.rw.finance.common.pay.PayerBo.UserInfo;
/**
 * 
 * @file DefaultPayer.java	
 * @author huanghongfei
 * @date 2018年1月4日 上午9:28:34
 * @declaration
 */
public class DefaultPayer implements Payer{

	@Override
	public String getBackUrl() {
		return new PayerFactory().ChuangXinPayer().getBackUrl();
	}
	
	@Override
	public PayResult auth(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		return new PayerFactory().EynonPayer().auth(userInfo, cardInfo, orderInfo);
	}

	@Override
	public PayResult pay(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		return new PayerFactory().ChuangXinPayer().pay(userInfo, cardInfo, orderInfo);
	}
	
	@Override
	public PayResult confirm(OrderInfo orderInfo) {
		return new PayerFactory().ChuangXinPayer().confirm(orderInfo);
	}

	@Override
	public PayResult reSendSms(OrderInfo orderInfo) {
		return new PayerFactory().ChuangXinPayer().reSendSms(orderInfo);
	}
	
	@Override
	public PayResult repay(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		return new PayerFactory().ChuangXinPayer().repay(userInfo, cardInfo, orderInfo);
	}

	@Override
	public PayResult queryOrder(OrderInfo orderInfo) {
		return new PayerFactory().ChuangXinPayer().queryOrder(orderInfo);
	}

	@Override
	public PayResult agentPay(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		return new PayerFactory().ChuangXinPayer().agentPay(userInfo, cardInfo, orderInfo);
	}


}
