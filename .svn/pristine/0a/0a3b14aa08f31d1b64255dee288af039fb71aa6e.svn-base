package com.rw.finance.common.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author huanghongfei
 * @file Md5Util.java
 * @date 2017年12月11日 下午4:44:04
 * @declaration
 */
public class Md5Util {

    public static String md5(String str) {
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            StringBuilder stringBuffer = new StringBuilder();
            for (byte b : bytes) {
                int bt = b & 0xff;
                if (bt < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return reStr;
    }

    public static String md5To16(String str) {
        String result = md5(str);
        if (result == null || result.isEmpty()) {
            return null;
        }

        if (result.length() == 32) {
            result = result.substring(8, 24);
        }

        return result.toUpperCase();
    }

    public static String md5ToBase64(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            return Base64.encodeBase64String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}