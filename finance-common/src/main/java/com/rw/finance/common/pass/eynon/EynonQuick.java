package com.rw.finance.common.pass.eynon;

import com.google.gson.Gson;
import com.rw.finance.common.entity.MemberCard;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.pay.PayerBo.CardInfo;
import com.rw.finance.common.pay.PayerBo.OrderInfo;
import com.rw.finance.common.pay.PayerBo.UserInfo;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Map;

/**
 * 爱农快捷支付
 */
public class EynonQuick extends EynonBase {
    private static final Logger log = LoggerFactory.getLogger(EynonQuick.class);
    private static final String MER_ID = "200000000000001";

    /**
     * 快捷支付订单申请
     */
    public Map<String,String> pay(UserInfo userInfo,CardInfo cardInfo,OrderInfo orderInfo) {
        Calendar calendar = Calendar.getInstance();
        Map<String, String> params = getBaseParams("01", "01");
        params.put("bizType", "001001");
        params.put("accessType", "2");
        params.put("accessMode", "06");
        params.put("merId", MER_ID);
        params.put("merOrderId",orderInfo.getTradeNo());
        params.put("accNo", cardInfo.getPayerCardNo());
        params.put("customerInfo", new Gson().toJson(getInfo(userInfo,cardInfo,"")));
        params.put("txnTime", DateFormatUtils.format(calendar.getTime(), "yyyyMMddHHmmss"));
        params.put("txnAmt",String.valueOf((long)(orderInfo.getBizAmount()*100)));
        params.put("currency", "CNY");
        calendar.add(Calendar.MINUTE, 30);
        params.put("payTimeOut", DateFormatUtils.format(calendar.getTime(), "yyyyMMddHHmmss"));
        params.put("backUrl", "http://xxx.com");
        params.put("payType", "0002");
        params.put("subject", "快捷支付");
        params.put("body", "消费");
        params = handler(Type.QUICK_ORDER, params);
        log.debug("{}", params);
        return params;
    }
    /**
     * 代付订单申请
     */
    public Map<String,String> repay(UserInfo userInfo,CardInfo cardInfo,OrderInfo orderInfo) {
        Calendar calendar = Calendar.getInstance();
        Map<String, String> params = getBaseParams("12", "01");
        params.put("bizType", "000401");
        params.put("accessType", "0");
        params.put("accessMode", "01");
        params.put("merId", MER_ID);
        params.put("merOrderId", String.valueOf(System.currentTimeMillis()));
        params.put("accNo", cardInfo.getPayerCardNo());
        params.put("accType","01");
        params.put("customerInfo", new Gson().toJson(getInfo(userInfo,cardInfo,"")));
        params.put("txnTime", DateFormatUtils.format(calendar.getTime(), "yyyyMMddHHmmss"));
        params.put("txnAmt",String.valueOf((long)(orderInfo.getBizAmount()*100)));
        params.put("currency", "CNY");
        params.put("backUrl", "http://www.xxx.com");
        params.put("payType", "0402");
        params.put("bankId", cardInfo.getPayerBankNo());
        params.put("subject", "T0代付");
        params.put("body", "代付");
        params.put("ppFlag", "01");
        params = handler(Type.QUICK_ORDER, params);
        log.debug("{}", params);
        return params;
    }

    /**
     * 发送短信验证码
     *
     * @param tn 平台流水号
     */
    public Map<String,String> sendSms(String tn) {
        Map<String, String> params = getBaseParams("77", "00");
        params.put("merId", MER_ID);
        params.put("tn", tn);
        params = handler(Type.QUICK_SMS, params);
        log.debug("{}", params);
        return params;
    }

    /**
     * 确认支付
     *
     * @param tn      平台流水号
     * @param smsCode 短信验证码
     */
    public Map<String, String> enterPay(String tn, String smsCode) {
        Map<String, String> params = getBaseParams("01", "02");
        params.put("merId", MER_ID);
        params.put("tn", tn);
        params.put("smsCode", smsCode);
        params = handler(Type.QUICK_ENTER, params);
        log.debug("{}", params);
        return params;
    }

    /**
     * 查询订单
     *
     * @param refund     true - 退款查询 false - 交易查询
     * @param merOrderId 商户订单号（我们自己生成的订单号）
     */
    public Map<String,String> queryOrder(boolean refund, String merOrderId) {
        Map<String, String> params = getBaseParams("00",refund ? "00" : "01");
        params.put("merId", MER_ID);
        params.put("merOrderId", merOrderId);
        params = handler(Type.QUICK_QUERY_ORDER, params);
        log.debug("{}", params);
        return params;
    }

    /**
     * 单笔退款
     *
     * @param merOrderId    退款订单号
     * @param orgMerOrderId 原商户订单号
     */
    public void refund(OrderInfo orderInfo) {
        Map<String, String> params = getBaseParams("04", "00");
        params.put("merId", MER_ID);
        params.put("merOrderId", orderInfo.getPayTradeNo());
        params.put("orgMerOrderId", orderInfo.getTradeNo());
        params.put("txnTime", "");
        params.put("txnAmt", "");
        params.put("currency", "CNY");
        params.put("backUrl", "");
        params = handler(Type.QUICK_REFUND, params);
        log.debug("{}", params);
    }

    /**
     * 异步通知签名验证
     */
    public boolean backNotify(Map<String, String> params) {
        return verifyResult(Type.ASYNC_NOTIFY, params);
    }

    /*public static void main(String[] args) {
        new EynonQuick().queryBalance(MER_ID);
    }*/
}
