package com.rw.finance.common.pass.eynon.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rw.finance.common.pass.eynon.MessageDigest;

import java.util.*;

public class SignUtils {

    private static Logger log = LoggerFactory.getLogger(SignUtils.class);

    /*public static Map<String, String> parseParam(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration paramsEnum = request.getParameterNames();
        while (paramsEnum.hasMoreElements()) {
            String paramName = String.valueOf(paramsEnum.nextElement());
            String paramValue = request.getParameter(paramName);
            map.put(paramName, paramValue);
        }
        return map;
    }*/

    public static Map<String, String> parseResponse(String msg) {
        Map<String, String> map = new HashMap<>();
        int beginIndex = 0, endIndex;
        while (true) {
            endIndex = msg.indexOf("=", beginIndex);
            String key, value;
            if (endIndex <= beginIndex) {
                break;
            }
            key = msg.substring(beginIndex, endIndex);
            beginIndex = endIndex + 1;
            if (beginIndex >= msg.length()) {
                map.put(key, "");
                break;
            }
            if (msg.charAt(beginIndex) == '{') {
                endIndex = msg.indexOf("}", beginIndex) + 1;
            } else {
                endIndex = msg.indexOf("&", beginIndex);
            }
            if (endIndex < beginIndex) {
                value = msg.substring(beginIndex);
                map.put(key, value);
                break;
            }
            value = msg.substring(beginIndex, endIndex);
            map.put(key, value);
            beginIndex = endIndex + 1;
        }
        return map;
    }

    public static String getURLParam(Map<String, String> map, boolean isSort, Set<String> removeKey) {
        StringBuilder param = new StringBuilder();
        List<String> msgList = new ArrayList<>();
        for (String key : map.keySet()) {
            String value = map.get(key);
            if (removeKey != null && removeKey.contains(key)) {
                continue;
            }
            msgList.add(key + "=" + (StringUtils.isNoneBlank(value) ? value : ""));
        }
        if (isSort) {
            Collections.sort(msgList);
        }
        for (int i = 0; i < msgList.size(); ++i) {
            String msg = msgList.get(i);
            if (i > 0) {
                param.append("&");
            }
            param.append(msg);
        }
        return param.toString();
    }

    public static String getSignMsg(Map<String, String> map, Set<String> removeKey) {
        return getURLParam(map, true, removeKey);
    }

    public static String sign(String signMethod, String signedMsg, String key, String charSet) {
        try {
            byte[] data = (signedMsg + key).getBytes(charSet);
            String[] algArray = {"MD5", "SHA1", "SHA256", "SHA512"};
            String algorithm = null;
            for (String anAlgArray : algArray) {
                if (anAlgArray.equalsIgnoreCase(signMethod)) {
                    algorithm = anAlgArray;
                    break;
                }
            }
            if (StringUtils.isEmpty(algorithm)) {
                log.error("签名方法错误signMethod=[" + signMethod + "]");
                return null;
            }
            return new String(Base64.encode(new MessageDigest(algorithm).sign(data)));
        } catch (Exception e) {
            log.error("签名异常：", e);
            return null;
        }
    }

    public static boolean verifySign(String signMethod, String signedMsg, String mac, String key, String charSet) {
        try {
            return !StringUtils.isEmpty(mac) && !StringUtils.isEmpty(signedMsg) && mac.equalsIgnoreCase(sign(signMethod, signedMsg, key, charSet));
        } catch (Exception e) {
            log.error("验证签名异常：", e);
            return false;
        }
    }
}