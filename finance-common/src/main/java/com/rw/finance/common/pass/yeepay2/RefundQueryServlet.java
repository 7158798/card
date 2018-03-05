package com.rw.finance.common.pass.yeepay2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.yeepay.g3.sdk.yop.client.YopClient3;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;

public class RefundQueryServlet {
	
	/*protected void doPost(){
		String refundRequestId 	= request.getParameter("refundRequestId");
		String orderId 			= request.getParameter("orderId");
		String uniqueRefundNo 	= request.getParameter("uniqueRefundNo");
		
		Map<String, String> params = new HashMap<>();
		params.put("refundRequestId", refundRequestId);
		params.put("orderId", orderId);
		params.put("uniqueRefundNo", uniqueRefundNo);
		
		Map<String, String> result = new HashMap<>();
		String uri = YeepayService.getUrl(YeepayService.REFUNDQUERY_URL);
		result = YeepayService.requestYOP(params, uri, YeepayService.REFUNDQUERY);
	}*/

}
