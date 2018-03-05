package com.rw.finance.common.pay;

import java.util.Map;

import com.rw.finance.common.pass.eynon.EynonQuick;
import com.rw.finance.common.pay.PayerBo.CardInfo;
import com.rw.finance.common.pay.PayerBo.OrderInfo;
import com.rw.finance.common.pay.PayerBo.UserInfo;
import com.rw.finance.common.utils.BankUtils;
/**
 * 爱农支付商
 * @file EynonPayer.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午1:38:14
 * @declaration
 */
public class EynonPayer implements Payer{
	
	@Override
	public String getBackUrl() {
		return "";
	}

	@Override
	public PayResult auth(UserInfo userInfo,CardInfo cardInfo,OrderInfo orderInfo) {
		BankUtils.AuthResult result=BankUtils.auth(new BankUtils().new CardInfo(cardInfo.getPayerCardNo(), userInfo.getPayerRealName(), userInfo.getPayerIdNo(),cardInfo.getPayerCardMobile()));
		boolean success=false;
		if(result.getError_code()==0){//储蓄卡鉴权
			success=true;
		}
		PayResult payResult=new PayResult(result.getError_code()+"", success,"","",result.getReason(),0);
		return payResult;
	}
	
	@Override
	public PayResult pay(UserInfo userInfo,CardInfo cardInfo,OrderInfo orderInfo) {
		Map<String,String> result=new EynonQuick().pay(userInfo, cardInfo, orderInfo);
		if(!"0000".equals(result.get("respCode"))){//支付请求成功
			 return new PayResult(result.get("respCode"), false, result.get("tn"),orderInfo.getTradeNo(),result.get("respMsg"),0);
		}
		Map<String,String> sendSmsResult=new EynonQuick().sendSms(orderInfo.getTradeNo());
		if(!"0000".equals(sendSmsResult.get("respCode"))){
			return new PayResult(sendSmsResult.get("respCode"), false, sendSmsResult.get("tn"),orderInfo.getTradeNo(),sendSmsResult.get("respMsg"),0);
		}
		return new PayResult(sendSmsResult.get("respCode"), true, sendSmsResult.get("tn"),orderInfo.getTradeNo(),sendSmsResult.get("respMsg"),0);
	}

	@Override
	public PayResult repay(UserInfo userInfo,CardInfo cardInfo,OrderInfo orderInfo) {
		Map<String,String> result=new EynonQuick().repay(userInfo, cardInfo, orderInfo);
		boolean success=false;
		if("0000".equals(result.get("respCode"))){
			success=true;
		}
		PayResult payResult=new PayResult(result.get("respCode"), success, result.get("tn"),orderInfo.getTradeNo(),result.get("respMsg"),0);
		return payResult;
	}

	@Override
	public PayResult queryOrder(OrderInfo orderInfo) {
		Map<String,String> result=new EynonQuick().queryOrder(false, orderInfo.getTradeNo());
		boolean success=false;
		if("0000".equals(result.get("respCode"))){
			success=true;
		}
		PayResult payResult=new PayResult(result.get("respCode"), success, result.get("tn"),orderInfo.getTradeNo(),result.get("respMsg"),0);
		return payResult;
	}

	@Override
	public PayResult confirm(OrderInfo orderInfo) {
		Map<String,String> result=new EynonQuick().enterPay(orderInfo.getPayTradeNo(), orderInfo.getSmsCode());
		boolean success=false;
		if("0000".equals(result.get("respCode"))){
			success=true;
		}
		PayResult payResult=new PayResult(result.get("respCode"), success, result.get("tn"),result.get("merOrderId"),result.get("respMsg"),0);
		return payResult;
	}
	
	@Override
	public PayResult reSendSms(OrderInfo orderInfo) {
		return null;
	}

	@Override
	public PayResult agentPay(UserInfo userInfo,
			com.rw.finance.common.pay.PayerBo.CardInfo cardInfo,
			OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return null;
	}



}
