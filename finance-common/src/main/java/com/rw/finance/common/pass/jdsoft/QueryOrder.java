package com.rw.finance.common.pass.jdsoft;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.rw.finance.common.pass.jdsoft.utils.HttpInvoker;
import com.rw.finance.common.pass.jdsoft.utils.SignUtils;
import com.rw.finance.common.pay.PayerBo;

/**
 * 根据订单号查询订单
 * 
 * @author zhengzhq
 *
 */
public class QueryOrder {

  // 查询订单的url
  private static final String queryOrderUrl = "https://pay.jdsoft.ltd/api/pay/v1/queryOrder";

  public static String queryOrder(PayerBo.OrderInfo orderInfo){
    List<NameValuePair> paramList = new ArrayList<NameValuePair>();
    // 合作方标识，由绝顶颁发
    paramList.add(new BasicNameValuePair("cooperator", "RYZX"));
    paramList.add(new BasicNameValuePair("algorithm", "RSA"));
    // 流水号
    paramList.add(new BasicNameValuePair("reqMsgId",orderInfo.getTradeNo()));
    // 银联快捷
    paramList.add(new BasicNameValuePair("oriReqMsgId",orderInfo.getTradeNo()));
    // 计算签名
    try {
		paramList.add(new BasicNameValuePair("sign", SignUtils.getSign(paramList)));
	} catch (Exception e) {
		e.printStackTrace();
	}
    String result = HttpInvoker.doPost(queryOrderUrl, paramList);
    System.out.println(result);
    return result;
  }
}
