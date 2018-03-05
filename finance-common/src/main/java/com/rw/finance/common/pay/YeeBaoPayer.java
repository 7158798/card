package com.rw.finance.common.pay;

import java.util.TreeMap;

import com.rw.finance.common.pass.yeepay.utils.PaymobileUtils;
import com.rw.finance.common.pay.PayerBo.CardInfo;
import com.rw.finance.common.pay.PayerBo.OrderInfo;
import com.rw.finance.common.pay.PayerBo.UserInfo;

/**
 * 
 * @file YeePayPayer.java	
 * @author huanghongfei
 * @date 2018年1月24日 下午5:54:37
 * @declaration
 */
public class YeeBaoPayer implements Payer{

	@Override
	public String getBackUrl() {
		return "http://api.rongyaozhixin.com/pay/back/yeeBaoPayBack";
	}

	@Override
	public PayResult auth(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		return null;
	}

	@Override
	public PayResult pay(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		TreeMap<String, Object> treeMap	= new TreeMap<String, Object>();
		treeMap.put("orderid", 			orderInfo.getTradeNo());//商户订单号
		treeMap.put("transtime", 		System.currentTimeMillis()/1000);//交易发生的时间
		treeMap.put("amount", 			(int)(orderInfo.getBizAmount()*100));//交易金额
		treeMap.put("currency", 		156);//交易币种
		treeMap.put("productcatalog", 	"20");//商品识别码
		treeMap.put("productname", 		"金融-投资");//商品名称
		//treeMap.put("productdesc", 		"");//商品描述
		treeMap.put("identitytype", 	3);//用户标识类型
		treeMap.put("identityid", 		cardInfo.getPayerCardMobile());//用户标识
		//treeMap.put("appId",			"");//微信公众号
		//treeMap.put("terminaltype", 	terminaltype);//终端标识类型
		//treeMap.put("terminalid", 	terminalid);//终端标识ID
		treeMap.put("userip", 			"127.0.0.1");//用户IP地址
		//treeMap.put("paytool", 			"");//支付工具
		//treeMap.put("directpaytype", 	"");//直联编码
		//treeMap.put("userua", 			userua);//终端设备UA
		//treeMap.put("fcallbackurl", 	"");//页面回调地址
		treeMap.put("callbackurl", 		orderInfo.getBackUrl());//后台回调地址
		treeMap.put("paytypes", 		"2");//支付方式,1借记卡，2贷记卡
		treeMap.put("orderexpdate", 	100*24*60);//订单有效期
		treeMap.put("cardno", 			cardInfo.getPayerCardNo());//银行卡号
		treeMap.put("idcardtype", 		"01");//证件类型
		treeMap.put("idcard", 			userInfo.getPayeeIdNo());//证件号
		treeMap.put("owner", 			userInfo.getPayerRealName());//持卡人姓名
		//treeMap.put("version", 			0);//收银台版本
		//treeMap.put("sign", 			"");//签名信息
		//第一步 生成AESkey及encryptkey
		String AESKey		= PaymobileUtils.buildAESKey();
		String encryptkey	= PaymobileUtils.buildEncyptkey(AESKey);

		//第二步 生成data
		String data			= PaymobileUtils.buildData(treeMap, AESKey);

		//第三步 获取商户编号及请求地址，并组装支付链接
		String merchantaccount	= PaymobileUtils.getMerchantaccount();
		String url				= PaymobileUtils.getRequestUrl(PaymobileUtils.PAYAPI_NAME);
		TreeMap<String, String> responseMap	= PaymobileUtils.httpPost(url, merchantaccount, data, encryptkey);

		//第四步 判断请求是否成功
		if(responseMap.containsKey("error_code")) {
			//请求失败处理
			return new PayResult(responseMap.get("error_code"), false, null, orderInfo.getTradeNo(), responseMap.get("error_msg"), 0);
		}
		//第五步 请求成功，则获取data、encryptkey，并将其解密
		String data_response						= responseMap.get("data");
		String encryptkey_response					= responseMap.get("encryptkey");
		TreeMap<String, String> responseDataMap	= PaymobileUtils.decrypt(data_response, encryptkey_response);
		//第六步 sign验签
		if(!PaymobileUtils.checkSign(responseDataMap)) {
			throw new RuntimeException("server under attack");
		}
		//第七步 判断请求是否成功
		if(!responseDataMap.containsKey("error_code")) {
			//请求失败处理
			return new PayResult("999999", true, responseDataMap.get("yborderid"), orderInfo.getTradeNo(),responseDataMap.get("payurl"), 0);
		}
		return new PayResult(responseMap.get("error_code"), false, null, orderInfo.getTradeNo(), responseMap.get("error_msg"), 0);
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
	public PayResult agentPay(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo) {
		return null;
	}

	@Override
	public PayResult queryOrder(OrderInfo orderInfo) {
		TreeMap<String, Object> treeMap	= new TreeMap<String, Object>();
		treeMap.put("orderid", 	orderInfo.getTradeNo());
		//第一步 生成AESkey及encryptkey
		String AESKey		= PaymobileUtils.buildAESKey();
		String encryptkey	= PaymobileUtils.buildEncyptkey(AESKey);
		//第二步 生成data
		String data			= PaymobileUtils.buildData(treeMap, AESKey);
		//第三步 http请求，订单查询接口的请求方式为GET
		String merchantaccount				= PaymobileUtils.getMerchantaccount();
		String url							= PaymobileUtils.getRequestUrl(PaymobileUtils.QUERYORDERAPI_NAME);
		TreeMap<String, String> responseMap	= PaymobileUtils.httpGet(url, merchantaccount, data, encryptkey);
		//第四步 判断请求是否成功
		if(responseMap.containsKey("error_code")) {
			return new PayResult(responseMap.get("error_code"), false, orderInfo.getPayTradeNo(), orderInfo.getTradeNo(), "", 0);
		}
		//第五步 请求成功，则获取data、encryptkey，并将其解密
		String data_response					= responseMap.get("data");
		String encryptkey_response				= responseMap.get("encryptkey");
		TreeMap<String, String> responseDataMap	= PaymobileUtils.decrypt(data_response, encryptkey_response);
		//第六步 sign验签
		if(!PaymobileUtils.checkSign(responseDataMap)) {
			throw new RuntimeException("server under attack");
		}
		//第七步 判断请求是否成功
		if(responseDataMap.containsKey("error_code")) {
			return new PayResult("999999",responseDataMap.get("status").equals("1")?true:false,responseDataMap.get("yborderid"), orderInfo.getTradeNo(),"", 0);
		}
		return null;
	}

}
