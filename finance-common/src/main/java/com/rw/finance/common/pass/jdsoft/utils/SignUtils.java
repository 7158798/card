package com.rw.finance.common.pass.jdsoft.utils;

import java.security.interfaces.RSAPrivateKey;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.http.NameValuePair;

public class SignUtils {

  public static String getSign(List<NameValuePair> paramList) throws Exception {
    // 将参数按照字母顺序排列
    Map<String, String> paramMap = new TreeMap<String, String>();
    for (NameValuePair nameValue : paramList) {
      paramMap.put(nameValue.getName(), nameValue.getValue());
    }

    // 拼接成a=xx&b=xx的格式
    StringBuilder dataBuilder = new StringBuilder();
    Iterator<String> it = paramMap.keySet().iterator();
    while (it.hasNext()) {
      String paramName = it.next();
      String paramValue = paramMap.get(paramName);
      if (dataBuilder.length() > 0) {
        dataBuilder.append("&");
      }
      dataBuilder.append(paramName).append("=").append(paramValue);
    }
    // 通过私钥计算签名
    RSAPrivateKey rsaPrivateKey = KeyInitialzer.initPrivateKey();
    return RSAHelper.getSign(dataBuilder.toString(), rsaPrivateKey);
  }
}
