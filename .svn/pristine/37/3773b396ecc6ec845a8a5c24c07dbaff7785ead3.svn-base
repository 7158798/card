package com.rw.finance.common.pass.eynon;

import com.rw.finance.common.entity.MemberCard;
import com.rw.finance.common.pass.eynon.utils.Base64;
import com.rw.finance.common.pass.eynon.utils.SignUtils;
import com.rw.finance.common.pay.PayerBo.CardInfo;
import com.rw.finance.common.pay.PayerBo.UserInfo;
import com.rw.finance.common.utils.HttpUtils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EynonBase {

    private static final Logger log = LoggerFactory.getLogger(EynonBase.class);
    private static final String API = "http://180.169.129.78:38280";
    private static final String API_ORDER = API + "/bas/BgTrans";
    private static final String KEY = "88888888";
    private static final String ENCODE = "UTF-8";
    private static final String RSAPubKey = "";
    private static final Set<String> base64Key = new HashSet<>();
    // 对内容做Base64加密
    private final String[] base64Keys = new String[]{"subject", "body", "remark"};
    // 对内容做Base64加密， 所有子域采用json数据格式
    private final String[] base64JsonKeys = new String[]{"customerInfo", "accResv", "riskRateInfo", "billQueryInfo", "billDetailInfo"};

    static {
        base64Key.add("subject");
        base64Key.add("body");
        base64Key.add("remark");
        base64Key.add("customerInfo");
        base64Key.add("accResv");
        base64Key.add("riskRateInfo");
        base64Key.add("billpQueryInfo");
        base64Key.add("billDetailInfo");
        base64Key.add("respMsg");
        base64Key.add("resv");
    }

    /**
     * 获取银行卡验证信息及身份信息
     *
     * @param accNo 银行卡号
     * @return 银行卡验证信息
     */
    Map<String, String> getInfo(UserInfo userInfo,CardInfo cardInfo,String code) {
        Map<String, String> info = new HashMap<>();
        info.put("issInsProvince", "");
        info.put("issInsCity", "");
        info.put("iss_ins_name", cardInfo.getPayerBankName());
        info.put("certifTp", "01");
        info.put("certify_id",cardInfo.getPayerCardNo());
        info.put("customerNm",userInfo.getPayerRealName());
        info.put("phoneNo",cardInfo.getPayerCardMobile());
        info.put("smsCode", code);
        info.put("cvv2", cardInfo.getPayerCardCvv2());
        return info;
    }

    Map<String, String> getBaseParams(String txnType, String txnSubType) {
        Map<String, String> params = new HashMap<>();
        params.put("signMethod", "MD5");
        params.put("version", "1.0.0");
        params.put("txnType", txnType);
        params.put("txnSubType", txnSubType);
        return params;
    }

    Map<String, String> handler(Type type, Map<String, String> params) {
        try {
            setSignature(params);
            log.debug(type.getName() + "-请求：{}", params);
            convertData(params);
            String result = HttpUtils.getInstance().httpPost(API_ORDER, params);
            params = parseMsg(result);
            log.debug(type.getName() + "-返回：{}", params);
            return verifyResult(type, params) ? params : null;
        } catch (Exception e) {
            log.error("处理请求异常：", e);
        }
        return null;
    }

    boolean verifyResult(Type type, Map<String, String> params) {
        String code = params == null ? null : params.get("respCode");
        String msg = params == null ? null : params.get("respMsg");
        if ("0000".equals(code) && verifySign(params)) {
            log.debug(type.getName() + "-返回：结果有效[ {} ]", msg);
            return true;
        } else {
            log.debug(type.getName() + "-返回：结果无效[ {} -> {} ]", code, msg);
            return false;
        }
    }

    /**
     * 设置签名
     */
    private void setSignature(Map<String, String> paramMap) {
        String signMethod = paramMap.get("signMethod");
        Set<String> removeKey = new HashSet<>();
        removeKey.add("signMethod");
        removeKey.add("signature");
        String signMsg = SignUtils.getSignMsg(paramMap, removeKey);
        if ("RSA".equals(signMethod)) {
            try {
                String signature = sign(signMsg.getBytes(ENCODE), RSAPubKey);
                paramMap.put("signature", signature);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        } else {
            String signature = SignUtils.sign(signMethod, signMsg, KEY, ENCODE);
            paramMap.put("signature", signature);
        }
    }

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data       //加密数据
     * @param privateKey //私钥
     */
    protected static String sign(byte[] data, String privateKey) throws Exception {
        //解密私钥
        byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(privateKey);
        //构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        //指定加密算法
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        //取私钥匙对象
        PrivateKey privateKey2 = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        //用私钥对信息生成数字签名
        Signature signature = Signature.getInstance("SHA1WithRSA");
        signature.initSign(privateKey2);
        signature.update(data);
        return new String(Base64.encode(signature.sign()));
    }

    /**
     * 转换报文格式及特殊字段base64解码
     */
    private Map<String, String> parseMsg(String msg) {
        Map<String, String> map = SignUtils.parseResponse(msg);
        // 特殊字段base64解码
        for (String key : base64Key) {
            String value = map.get(key);
            if (StringUtils.isNotEmpty(value)) {
                try {
                    String text = new String(Base64.decode(value.toCharArray()), ENCODE);
                    map.put(key, text);
                } catch (Exception ignored) {
                }
            }
        }
        return map;
    }

    /**
     * BASE64加密
     */
    public String base64encode(String data) {
        try {
            return new String(Base64.encode(data.getBytes(ENCODE)));
        } catch (Exception e) {
            log.error("BASE64加密异常：", e);
            return data;
        }
    }

    /**
     * BASE64解密
     */
    public String base64decode(String data) {
        try {
            return new String(Base64.decode(data.toCharArray()), ENCODE);
        } catch (Exception e) {
            log.error("BASE64解密异常：", e);
            return data;
        }
    }

    /**
     * 验签
     */
    private boolean verifySign(Map<String, String> paramMap) {
        // 计算签名
        Set<String> removeKey = new HashSet<>();
        removeKey.add("signMethod");
        removeKey.add("signature");
        String signedMsg = SignUtils.getSignMsg(paramMap, removeKey);
        String signMethod = paramMap.get("signMethod");
        String signature = paramMap.get("signature");
        // 密钥
        if ("RSA".equals(signMethod)) {
            return doCheck(signedMsg, signature, RSAPubKey, ENCODE);
        }
        return SignUtils.verifySign(signMethod, signedMsg, signature, KEY, ENCODE);
    }

    /**
     * RSA验签名检查
     *
     * @param content   待签名数据
     * @param sign      签名值
     * @param publicKey 分配给开发商公钥
     * @param encode    字符集编码
     * @return 布尔值
     */
    private static boolean doCheck(String content, String sign, String publicKey, String encode) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = (new BASE64Decoder()).decodeBuffer(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(pubKey);
            signature.update(content.getBytes(encode));
            return signature.verify(Base64.decode(sign.toCharArray()));
        } catch (Exception e) {
            log.error("RSA验签名检查异常", e);
        }
        return false;
    }

    private void convertData(Map<String, String> paramMap) {
        convertMap(base64Keys, paramMap);
        convertMap(base64JsonKeys, paramMap);
    }

    private void convertMap(String[] array, Map<String, String> paramMap) {
        for (String key : array) {
            String value = paramMap.get(key);
            if (StringUtils.isNotEmpty(value)) {
                try {
                    String text = new String(Base64.encode(value.getBytes(ENCODE)));
                    // 更新请求参数
                    paramMap.put(key, text);
                } catch (Exception ignored) {
                }
            }
        }
    }

    /**
     * 查询余额
     */
    public void queryBalance(String merId) {
        Map<String, String> params = getBaseParams("71", "00");
        params.put("merId", merId);
        params = handler(Type.QUERY_BALANCE, params);
        log.debug("{}", params);
    }
    /**
     * 根据返回码获取错误消息
     * @param errorCode
     * @return
     */
    protected String getError(String errorCode){
    	Map<String,String> errorMap=new HashMap<String,String>();
    	errorMap.put("0000", "接受通知成功");
    	errorMap.put("0001", "参数错误");
    	errorMap.put("0002", "签名错误");
    	errorMap.put("1001", "交易成功");
    	errorMap.put("1002", "交易失败");
    	errorMap.put("1003", "已退款");
    	errorMap.put("1111", "交易进行中");
    	errorMap.put("2000", "无效商户");
    	errorMap.put("2001", "重复交易");
    	errorMap.put("2002", "查无此交易");
    	errorMap.put("2003", "交易金额超限");
    	errorMap.put("2004", "原交易不存在或状态不正确");
    	errorMap.put("2005", "与原交易信息不符");
    	errorMap.put("2006", "已超过最大查询次数或操作过于频繁");
    	errorMap.put("2007", "风控受限");
    	errorMap.put("2008", "交易不在受理时间范围内");
    	errorMap.put("2009", "扣款成功但交易超过指定支付时间");
    	errorMap.put("2010", "订单金额不匹配");
    	errorMap.put("2011", "订单币种不匹配");
    	errorMap.put("2012", "卡信息或银行预留手机号有误");
    	errorMap.put("2013", "密码错误次数超限");
    	errorMap.put("2014", "密码验证失败");
    	errorMap.put("2015", "短信验证码错误");
    	errorMap.put("2016", "CVN验证失败");
    	errorMap.put("2017", "身份证号有误");
    	errorMap.put("2018", "短信验证码发送次数超限");
    	errorMap.put("2019", "短信验证码发送频率过高");
    	errorMap.put("2020", "短信验证码验证错误次数超限");
    	errorMap.put("2021", "短信校验码已过期");
    	errorMap.put("2022", "姓名有误");
    	errorMap.put("2023", "银行预留手机号有误");
    	errorMap.put("2024", "银行卡无效或状态有误");
    	errorMap.put("2025", "余额不足");
    	errorMap.put("2026", "请持卡人与发卡银行联系");
    	errorMap.put("9999", "系统繁忙");
    	return errorMap.get(errorCode);
    }
}
