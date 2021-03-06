package com.rw.finance.client.controller;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.rw.finance.common.pass.chuangxin.ChuangXinPayResponse;
import com.rw.finance.common.pass.jdsoft.utils.KeyInitialzer;
import com.rw.finance.common.pass.jdsoft.utils.RSAHelper;
import com.rw.finance.common.pass.yeepay.utils.PaymobileUtils;
import com.rw.finance.common.pass.yeepay2.YeepayService;
import com.rw.finance.common.service.PayResultService;
import com.yeepay.g3.facade.yop.ca.dto.DigitalEnvelopeDTO;
import com.yeepay.g3.facade.yop.ca.enums.CertTypeEnum;
import com.yeepay.g3.frame.yop.ca.DigitalEnvelopeUtils;
import com.yeepay.g3.sdk.yop.utils.InternalConfig;

/**
 * 支付回调
 * @file PayResultController.java	
 * @author huanghongfei
 * @date 2017年12月23日 下午5:16:39
 * @declaration
 */
@RestController
@RequestMapping(value="/pay/back")
public class PayResultController {

	@Reference
	private PayResultService payResultService;
	/**
	 * 爱农支付回调(eynon支付回调)
	 * @return
	 */
	@RequestMapping(value="/EynonPayBack")
	public Object eynonBack(@RequestParam(value="merOrderId",required=true)String merOrderId){
		return "success";
	}
	/**
	 * 创新支付回调接口
	 * @return
	 */
	@RequestMapping(value="/ChuangXinPayBack")
	public ChuangXinPayResponse chuangXinBack(@RequestParam(value="orderNo")String orderNo,
			@RequestParam(value="merchantNo")String merchantNo,
			@RequestParam(value="sign")String sign){
		payResultService.chuangXinPayBack(orderNo);
		return new ChuangXinPayResponse(merchantNo, "SUCCESS",sign);
	}
	/**
	 * 易宝支付回调
	 * @param data
	 * @param encryptkey
	 * @return
	 */
	@RequestMapping(value="/yeeBaoPayBack")
	public String yeeBaoPayBack(@RequestParam(value="data")String data,
			@RequestParam(value="encryptkey")String encryptkey){
		//解密data
		TreeMap<String, String>	dataMap	= PaymobileUtils.decrypt(data, encryptkey);
		//sign验签
		if(!PaymobileUtils.checkSign(dataMap)) {
			throw new RuntimeException("server under attack");
		}
		payResultService.yeeBaoPayBack(dataMap.get("orderid"));
		return "SUCCESS";
	}
	/**
	 * 易宝支付回调
	 * @param data
	 * @param encryptkey
	 * @return
	 */
	@RequestMapping(value="/yeeBao2PayBack")
	public String yeeBao2PayBack(@RequestParam(value="response")String response,
			@RequestParam(value="customerIdentification")String customerIdentification){
		Map<String,String> result=YeepayService.callback(response);
		payResultService.yeeBao2PayBack(result.get("orderId"));
		return "SUCCESS";
	}
	/**
	 * 易宝2代付回调
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/yeeBao2AgentPayBack")
	public String yeeBao2AgentPayBack(HttpServletRequest request){
		Map<String, String> jsonMap = new HashMap<>();
		DigitalEnvelopeDTO dto = new DigitalEnvelopeDTO();
		dto.setCipherText(request.getParameter("response"));
		PrivateKey privateKey = InternalConfig.getISVPrivateKey(CertTypeEnum.RSA2048);
		PublicKey publicKey = InternalConfig.getYopPublicKey(CertTypeEnum.RSA2048);
		dto = DigitalEnvelopeUtils.decrypt(dto, privateKey, publicKey);
		jsonMap =JSON.parseObject(dto.getPlainText(),new TypeReference<TreeMap<String, String>>() {});
		payResultService.yeeBao2AgentPayBack(jsonMap.get("orderId"));
		return "SUCCESS";
	}
	/**
	 * 绝顶支付回调
	 * @param data 密文
	 * @return
	 */
	@RequestMapping(value="/jdsoftPayBack")
	public String jdsoftPayBack(@RequestParam(value="data")String data){
		RSAPrivateKey rsaPrivateKey = KeyInitialzer.initPrivateKey();
		data=RSAHelper.decryptWithPKCS1(data,rsaPrivateKey);
		System.err.println(data);
		Map<String,Object> params=new Gson().fromJson(data, Map.class);
		payResultService.jdsoftPayBack(params.get("reqMsgId").toString());
		return "success";
	}
}
