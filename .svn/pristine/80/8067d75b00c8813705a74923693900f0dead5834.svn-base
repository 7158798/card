package com.rw.finance.common.pay;

import java.util.Map;

import com.google.gson.Gson;
import com.rw.finance.common.pass.jdsoft.QueryOrder;
import com.rw.finance.common.pass.jdsoft.UnionPay;
import com.rw.finance.common.pass.jdsoft.utils.JdsoftResponse;
import com.rw.finance.common.pay.PayerBo.CardInfo;
import com.rw.finance.common.pay.PayerBo.OrderInfo;
import com.rw.finance.common.pay.PayerBo.UserInfo;

/**
 * 绝顶支付实现类
 * @file JdsoftPayer.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午1:27:53
 * @declaration
 */
public class JdsoftPayer implements Payer{

	@Override
	public String getBackUrl() {
		return "http://api.rongyaozhixin.com/pay/back/jdsoftPayBack";
	}

	@Override
	public PayResult auth(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		return null;
	}

	@Override
	public PayResult pay(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		String result=UnionPay.unionPay(userInfo, cardInfo, orderInfo);
		JdsoftResponse response=new Gson().fromJson(result,JdsoftResponse.class);
		return new PayResult(response.getMeta().getCode()+"",response.getMeta().getCode()==200?true:false,"", orderInfo.getTradeNo(), response.getData().getUrl(), 0);
	}

	@Override
	public PayResult confirm(OrderInfo orderInfo) {
		return null;
	}

	@Override
	public PayResult reSendSms(OrderInfo orderInfo) {
		return null;
	}
	
	@Override
	public PayResult repay(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		return null;
	}
	
	@Override
	public PayResult queryOrder(OrderInfo orderInfo) {
		String result=QueryOrder.queryOrder(orderInfo);
		System.err.println(result);
		JdsoftResponse response=new Gson().fromJson(result,JdsoftResponse.class);
		return new PayResult(response.getMeta().getCode()+"",response.getMeta().getCode()==200?true:false,"", orderInfo.getTradeNo(), result, 0);
	}
	
	@Override
	public PayResult agentPay(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		return null;
	}

}
