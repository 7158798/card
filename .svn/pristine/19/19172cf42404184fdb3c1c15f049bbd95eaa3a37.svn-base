package com.rw.finance.common.pass.jdsoft;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.rw.finance.common.pass.jdsoft.utils.HttpInvoker;
import com.rw.finance.common.pass.jdsoft.utils.SignUtils;
import com.rw.finance.common.pay.PayerBo;

/**
 * 测试支付
 * 
 * @author zhengzhq
 *
 */
public class GatewayPay {

  // 产线地址
  private static final String startPayUrl = "https://pay.jdsoft.ltd/api/pay/v2/startPay";


  /**
   * 测试下单接口
   * 
   * @throws Exception
   */
  /*public static void gatewayPay(PayerBo.UserInfo userInfo,PayerBo.CardInfo cardInfo,PayerBo.OrderInfo orderInfo){
    List<NameValuePair> paramList = new ArrayList<NameValuePair>();
    // 合作方标识，由绝顶颁发
    paramList.add(new BasicNameValuePair("cooperator", "RYZX"));
    paramList.add(new BasicNameValuePair("algorithm", "RSA"));
    // 流水号
    paramList.add(new BasicNameValuePair("reqMsgId",orderInfo.getTradeNo()));
    // type=4为网关接口
    paramList.add(new BasicNameValuePair("type", "1"));
    // 到账卡
    paramList.add(new BasicNameValuePair("payeeCard", cardInfo.getPayeeCardNo()));
    // 到账卡持有者姓名
    paramList.add(new BasicNameValuePair("payeeName", userInfo.getPayeeRealName()));
    // 金额
    paramList.add(new BasicNameValuePair("money",String.valueOf(orderInfo.getBizAmount())));
    // 固定费率，单位：元
    //paramList.add(new BasicNameValuePair("fixedFee", "35"));
    // 交易费率，单位：元/万
    paramList.add(new BasicNameValuePair("tradeRate", "35"));
    // 计算签名
    try {
		paramList.add(new BasicNameValuePair("sign", SignUtils.getSign(paramList)));
	} catch (Exception e) {
		e.printStackTrace();
	}
    String result = HttpInvoker.doPost(startPayUrl, paramList);
    System.out.println(result);
  }*/
}
