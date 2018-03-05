package com.rw.finance.common.pass.yeepay2.agent;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.yeepay.g3.facade.yop.ca.dto.DigitalEnvelopeDTO;
import com.yeepay.g3.facade.yop.ca.enums.CertTypeEnum;
import com.yeepay.g3.frame.yop.ca.DigitalEnvelopeUtils;
import com.yeepay.g3.sdk.yop.utils.InternalConfig;

public class NotifyServlet {
	public static void main(String[] args) {
		String response = "";
		try {
			// 开始解密
			Map<String, String> jsonMap = new HashMap<>();
			DigitalEnvelopeDTO dto = new DigitalEnvelopeDTO();
			dto.setCipherText(response);
			PrivateKey privateKey = InternalConfig.getISVPrivateKey(CertTypeEnum.RSA2048);
			System.out.println("privateKey: " + privateKey);
			PublicKey publicKey = InternalConfig.getYopPublicKey(CertTypeEnum.RSA2048);
			System.out.println("publicKey: " + publicKey);
			dto = DigitalEnvelopeUtils.decrypt(dto, privateKey, publicKey);
			System.out.println("-------:" + dto.getPlainText());
			jsonMap = parseResponse(dto.getPlainText());
			System.out.println(jsonMap);
		} catch (Exception e) {
			throw new RuntimeException("回调解密失败！");
		}

	}

	public static Map<String, String> parseResponse(String response) {
		Map<String, String> jsonMap = new HashMap<>();
		jsonMap = JSON.parseObject(response,new TypeReference<TreeMap<String, String>>() {});
		return jsonMap;
	}
}
