package com.rw.finance.common.pay;

import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.rw.finance.common.pass.chuangxin.ChuangXinPay;
import com.rw.finance.common.pay.PayerBo.CardInfo;
import com.rw.finance.common.pay.PayerBo.OrderInfo;
import com.rw.finance.common.pay.PayerBo.UserInfo;

public class ChuangXinPayer implements Payer{

	@Override
	public String getBackUrl() {
		return "http://api.rongyaozhixin.com/pay/back/ChuangXinPayBack";
	}
	//TODO 接口未实现
	@Override
	public PayResult auth(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		return null;
	}

	@Override
	public PayResult pay(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		String resultJson=ChuangXinPay.quickPayApply(userInfo, cardInfo, orderInfo);
		ChuangXinPay.Result result=new Gson().fromJson(resultJson, ChuangXinPay.Result.class);
		if(result.getDealCode().equals("10000")){
			if(result.getNeedSms().equals("0")){//需要发送短信验证码
				ChuangXinPay.quickPayReSendVfCode(orderInfo);
			}else{//不需要短信验证码，但也需要确认
				ChuangXinPay.quickPayConfirm(orderInfo);
			}
		}
		PayResult payResult=new PayResult(result.getDealCode(),result.getDealCode().equals("10000")?true:false, result.getCxOrderNo(), result.getOrderNo(),result.getDealMsg(),"0".equals(result.getNeedSms())?1:0);
		payResult.setResult(resultJson);
		return payResult;
	}

	@Override
	public PayResult confirm(OrderInfo orderInfo) {
		String resultJson=ChuangXinPay.quickPayConfirm(orderInfo);
		ChuangXinPay.Result result=new Gson().fromJson(resultJson, ChuangXinPay.Result.class);
		boolean success=false;
		if(result.getDealCode().equals("10000")){
			success=true;
		}
		return new PayResult(result.getDealCode(), success, result.getCxOrderNo(), result.getOrderNo(),result.getDealMsg(),1);
	}

	@Override
	public PayResult reSendSms(OrderInfo orderInfo) {
		String resultJson=ChuangXinPay.quickPayReSendVfCode(orderInfo);
		if(StringUtils.isEmpty(resultJson)){
			new PayResult("500", false, orderInfo.getPayTradeNo(), orderInfo.getTradeNo(), "", 0);
		}
		ChuangXinPay.Result result=new Gson().fromJson(resultJson, ChuangXinPay.Result.class);
		PayResult payResult=new PayResult(result.getDealCode(),result.getDealCode().equals("10000")?true:false, result.getCxOrderNo(), result.getOrderNo(),result.getDealMsg(),"0".equals(result.getNeedSms())?1:0);
		payResult.setResult(resultJson);
		return payResult;
	}
	
	@Override
	public PayResult repay(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		String resultJson=ChuangXinPay.payForSameName(userInfo, cardInfo, orderInfo);
		ChuangXinPay.Result result=new Gson().fromJson(resultJson, ChuangXinPay.Result.class);
		boolean success=false;
		if(result.getDealCode().equals("10000")){
			success=true;
		}
		return new PayResult(result.getDealCode(), success, result.getCxOrderNo(), result.getOrderNo(),result.getDealMsg(),1);
	}

	@Override
	public PayResult queryOrder(OrderInfo orderInfo) {
		String resultJson=ChuangXinPay.payForAnotherOneSearchForQuckly(orderInfo);
		ChuangXinPay.Result result=new Gson().fromJson(resultJson, ChuangXinPay.Result.class);
		if(result.getDealCode().equals("30001")){//快捷查询订单不存在,调用代付查询接口
			resultJson=ChuangXinPay.payForAnotherOneSearch(orderInfo);
			result=new Gson().fromJson(resultJson, ChuangXinPay.Result.class);
		}
		boolean success=false;
		if(result.getDealCode().equals("10000")){
			success=true;
		}
		PayResult payResult=new PayResult(result.getDealCode(), success, result.getCxOrderNo(), result.getOrderNo(),result.getDealMsg(),1);
		payResult.setResult(resultJson);
		return payResult;
	}
	
	@Override
	public PayResult agentPay(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		String resultJson=ChuangXinPay.payForAnotherOne(userInfo, cardInfo, orderInfo);
		ChuangXinPay.Result result=new Gson().fromJson(resultJson, ChuangXinPay.Result.class);
		boolean success=false;
		if(result.getDealCode().equals("10000")){
			success=true;
		}
		return new PayResult(result.getDealCode(), success, result.getCxOrderNo(), result.getOrderNo(),result.getDealMsg(),0);
	}
	

}
