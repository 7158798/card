package com.rw.finance.common.pass.yeepay;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

import com.rw.finance.common.pass.yeepay.utils.ConvertUtils;
import com.rw.finance.common.pass.yeepay.utils.PaymobileUtils;
import com.rw.finance.common.pay.PayerBo;
import com.rw.finance.common.utils.UuidUtil;

/**
 * 支付接口 
 * @author: yingjie.wang    
 * @since : 2015-10-08 22:06
 */

public class PayApiServlet{

	/**
	 * 下单接口
	 * @param userInfo
	 * @param cardInfo
	 * @param orderInfo
	 */
	public static void doPost(PayerBo.UserInfo userInfo,PayerBo.CardInfo cardInfo,PayerBo.OrderInfo orderInfo){
		//使用TreeMap
		TreeMap<String, Object> treeMap	= new TreeMap<String, Object>();
		treeMap.put("orderid", 			orderInfo.getTradeNo());//商户订单号
		treeMap.put("transtime", 		System.currentTimeMillis()/1000);//交易发生的时间
		treeMap.put("amount", 			(int)orderInfo.getBizAmount()*100);//交易金额
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
		treeMap.put("paytypes", 		"1");//支付方式
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
			return;
		}
		
		//第五步 请求成功，则获取data、encryptkey，并将其解密
		String data_response						= responseMap.get("data");
		String encryptkey_response					= responseMap.get("encryptkey");
		TreeMap<String, String> responseDataMap	= PaymobileUtils.decrypt(data_response, encryptkey_response);

		//第六步 sign验签
		if(!PaymobileUtils.checkSign(responseDataMap)) {
			//验签失败处理
			return;
		}

		//第七步 判断请求是否成功
		if(responseDataMap.containsKey("error_code")) {
			System.err.println(responseDataMap.get("error_code")+responseDataMap.get("error_msg"));
			//请求失败处理
			return;
		}
		
	}
	
	public static void main(String []orgs){
		PayApiServlet.doPost(new PayerBo().new UserInfo("500241199101146517", "曾宪学"), 
				new PayerBo().new CardInfo("中信银行","", "", "", "6226890139835192", "15320903578", "", ""), 
				new PayerBo().new OrderInfo(UuidUtil.tradeNoBuilder(""), "", 1, "", ""));
	}

}
