package com.rw.finance.common.pass.yeepay2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.View;

import com.yeepay.g3.sdk.yop.client.YopClient3;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;

/**
 * Servlet implementation class TakeTokenServlet
 */
public class TakeTokenServlet  {
	
	/*protected void doPost(){
		String orderId = request.getParameter("orderId");
		String orderAmount = request.getParameter("orderAmount");
		String timeoutExpress = request.getParameter("timeoutExpress");
		String requestDate = request.getParameter("requestDate");
		String redirectUrl = request.getParameter("redirectUrl");
		String notifyUrl = request.getParameter("notifyUrl");
		String goodsName = request.getParameter("goodsName");
		String goodsDesc = request.getParameter("goodsDesc");
		String paymentParamExt = request.getParameter("paymentParamExt");
		String bizSource = request.getParameter("bizSource");
		String bizEntity = request.getParameter("bizEntity");
		String memo = request.getParameter("memo");
		String riskParamExt = request.getParameter("riskParamExt");
		String csUrl = request.getParameter("csUrl");
		
		String goodsParamExt = "{\"goodsName\":\""+goodsName+"\",\"goodsDesc\":\""+goodsDesc+"\"}";
		String industryParamExt = "{\"bizSource\":\""+bizSource+"\",\"bizEntity\":\""+bizEntity+"\"}";
		
		System.out.println("goodsParamExt:"+goodsParamExt);
		Map<String, String> params = new HashMap<>();
		params.put("orderId", orderId);
		params.put("orderAmount", orderAmount);
		params.put("timeoutExpress", timeoutExpress);
		params.put("requestDate", requestDate);
		params.put("redirectUrl", redirectUrl);
		params.put("notifyUrl", notifyUrl);
		params.put("goodsParamExt", goodsParamExt);
		params.put("paymentParamExt", paymentParamExt);
		params.put("industryParamExt", industryParamExt);
		params.put("memo", memo);
		params.put("riskParamExt", riskParamExt);
		params.put("csUrl", csUrl);
	
		System.out.println(params);
		String uri = YeepayService.getUrl(YeepayService.TRADEORDER_URL);
		Map<String, String> result = YeepayService.requestYOP(params, uri, YeepayService.TRADEORDER);
	}*/

}
