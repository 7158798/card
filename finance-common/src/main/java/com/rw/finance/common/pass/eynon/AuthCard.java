package com.rw.finance.common.pass.eynon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.google.gson.Gson;
import com.rw.finance.common.pass.eynon.utils.SignUtils;
import com.rw.finance.common.pay.PayerBo.CardInfo;
import com.rw.finance.common.pay.PayerBo.OrderInfo;
import com.rw.finance.common.pay.PayerBo.UserInfo;
import com.rw.finance.common.utils.HttpUtils;
import com.rw.finance.common.utils.Md5Util;

/**
 * 信用卡鉴权
 * @file AuthCard.java	
 * @author huanghongfei
 * @date 2017年12月20日 下午7:36:52
 * @declaration
 */
public class AuthCard extends EynonBase{
	/**
	 * 请求地址
	 */
	private static final String request_url="http://116.62.140.1:81/payapi/dspgateway";
	/**
	 * 商户号
	 */
	private static final String merchant_no="MCH00002";
	/**
	 * 方法名
	 */
	private static final String method="unified.trade.dsp";
	/**
	 * 版本号
	 */
	private static final String version="1.0";
	/**
	 * md5key
	 */
	private static final String md5Key="86a89a15843b474a95c5b315e7265b7d";
	/**
	 * 鉴权,String out_trade_no,String name,String id_no,String card_no
	 * @param out_trade_no 商户请求流水号 M
	 * @param name 持卡人姓名 M
	 * @param id_no 证件号码 M
	 * @param phone 手机号 O
	 * @param card_no 银行卡号 M
	 * @param cvn2 CVN2 O
	 * @param exp 有效期 O
	 * @return
	 * code 消息代码
	 * msg 请求消息说明
	 * sign 签名串
	 * status 验证状态
	 * trade_no 平台流水号
	 * out_trade_no 商家流水号
	 */
	public static AuthResult auth(UserInfo userInfo,CardInfo cardInfo,OrderInfo orderInfo){
		Map<String,String> params=new HashMap<String,String>();
		params.put("merchant_no",merchant_no);
		params.put("method",method);
		params.put("version",version);
		params.put("out_trade_no",orderInfo.getTradeNo());
		params.put("timestamp",String.valueOf(System.currentTimeMillis()));
		params.put("name",userInfo.getPayerRealName());
		params.put("id_type","01");
		params.put("id_no",userInfo.getPayerIdNo());
		params.put("card_type","01");
		params.put("card_no",cardInfo.getPayerCardNo());
		try {
			String sign=Md5Util.md5(AuthCard.getValue(SignUtils.getURLParam(params, true,new HashSet<String>()))+md5Key);
			String url=request_url
					+"?merchant_no="+merchant_no
					+"&method="+method
					+"&version="+version
					+"&out_trade_no="+orderInfo.getTradeNo()
					+"&timestamp="+String.valueOf(System.currentTimeMillis())
					+"&name="+userInfo.getPayerRealName()
					+"&id_type=01"
					+"&id_no="+userInfo.getPayerIdNo()
					+"&card_type=01"
					+"&card_no="+cardInfo.getPayerCardNo()
					+"&sign="+sign;
			String result=HttpUtils.getInstance().httpPost(url,params);
			System.out.println(result);
			return new Gson().fromJson(result,AuthResult.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	/**
	 * 从参数列表中提取value
	 * @return
	 */
	public static String getValue(String params){
		params=params.replace("&",String.format("%c", 0x20));
		String[] strs=params.split(String.format("%c", 0x20));
		StringBuffer value=new StringBuffer();
		for(int i=0;i<strs.length;i++){
			String[] str=strs[i].split("=");
			if(str.length<2){
				continue;
			}
			value.append(str[1]);
		}
		return value.toString();
	}
	/**
	 * AES加密
	 * @param data
	 * @param key
	 * @return
	 */
	public static byte[] encrypt(byte[] data, byte[] key) {
		try {
			SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec seckey = new SecretKeySpec(enCodeFormat,"AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// 创建密码器
			cipher.init(Cipher.ENCRYPT_MODE, seckey);// 初始化
			byte[] result = cipher.doFinal(data);
			return result; // 加密
		} catch (Exception e){
			throw new RuntimeException("encrypt fail!", e);
		}
	}
	
	
	/*public static void main(String []args){
		AuthCard.ahth(String.valueOf(System.nanoTime()),"黄洪飞","500221199210021718","6221516530008644030").getCode();
	}*/
	/**
	 * 结果对象
	 * @file AuthCard.java	
	 * @author huanghongfei
	 * @date 2017年12月21日 上午10:39:00
	 * @declaration
	 */
	public class AuthResult{
		private String code;
		private String msg;
		private String sign;
		private String status;
		private String trade_no;
		private String out_trade_no;
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public String getSign() {
			return sign;
		}
		public void setSign(String sign) {
			this.sign = sign;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getTrade_no() {
			return trade_no;
		}
		public void setTrade_no(String trade_no) {
			this.trade_no = trade_no;
		}
		public String getOut_trade_no() {
			return out_trade_no;
		}
		public void setOut_trade_no(String out_trade_no) {
			this.out_trade_no = out_trade_no;
		}
	}
}
