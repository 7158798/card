package com.rw.finance.common.pass.yeepay2;

import java.util.HashMap;
import java.util.Map;

import com.rw.finance.common.pay.PayerBo;
/**
 * Servlet implementation class OrderQueryServlet
 */
public class OrderQueryServlet{
	
	public static void doPost(PayerBo.OrderInfo orderInfo){
		Map<String, String> params = new HashMap<>();
		params.put("orderId", orderInfo.getTradeNo());
		params.put("uniqueOrderNo", orderInfo.getPayTradeNo());
		Map<String, String> result = new HashMap<>();
		String uri = YeepayService.getUrl(YeepayService.ORDERQUERY_URL);
		result = YeepayService.requestYOP(params, uri, YeepayService.ORDERQUERY);
		System.err.println(result);
	}

}
