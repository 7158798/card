package com.rw.finance.common.pass.yeepay2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

import com.rw.finance.common.pay.PayerBo;

/**
 * Created by songjinfengPC on 2017/4/24.
 * <p>
 * 手机支付的请求接口地址
 */
public class MobilePayServlet {

    //获取token请求参数列表
    static String[] params = {"parentMerchantNo", "merchantNo", "orderId", "orderAmount", "timeoutExpress", "requestDate", "redirectUrl", "notifyUrl", "goodsParamExt", "paymentParamExt", "memo", "riskParamExt"};

    //数据存储
    static HashMap<String, String> orderData = new HashMap<String, String>();

    //请求数据存储
    static Map<String, String> requestBasicParams = new HashMap<String, String>();

    static {
        requestBasicParams.put("parentMerchantNo", Configuration.getInstance().getValue("merchantNo"));
        requestBasicParams.put("merchantNo", Configuration.getInstance().getValue("merchantNo"));
        requestBasicParams.put("notifyUrl", "http://104.224.186.152:8080/FengTools_war/ServiceNotice");
    }

    /**
     * 接受请求
     *
     * @param request
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public static String doPost(PayerBo.UserInfo userInfo,PayerBo.CardInfo cardInfo,PayerBo.OrderInfo orderInfo){
        //填充信息
        Map<String, String> requesParams = new HashMap<String, String>();
        requesParams.putAll(requestBasicParams);
        requesParams.put("orderId", orderInfo.getTradeNo());
        requesParams.put("orderAmount", orderInfo.getBizAmount()+"");
        //requesParams.put("timeoutExpress", timeoutExpress);
        //requesParams.put("requestDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //requesParams.put("paymentParamExt", paymentParamExt);
        //requesParams.put("riskParamExt", riskParamExt);
        //requesParams.put("goodsParamExt", goodsParamExt);
        //获取YOP返回信息
        String[] signs = {"parentMerchantNo", "merchantNo", "orderId", "orderAmount", "timeoutExpress", "requestDate", "redirectUrl", "notifyUrl", "goodsParamExt", "paymentParamExt", "memo", "riskParamExt"};
        Map<String, String> response = YeepayService.requestYOP(requesParams, Configuration.getInstance().getValue("tradeOrderURI"), signs);
        response.get("token");
        System.out.println("token : " + response.get("token"));
        //签名数据信息
        //拼装签名字符串
        StringBuilder builder = new StringBuilder()
                .append("merchantNo=").append(Configuration.getInstance().getValue("merchantNo"))
                .append("&token=").append(response.get("token"))
                .append("&timestamp=").append(System.currentTimeMillis()/1000)
                .append("&directPayType=").append("")
                .append("&cardType=").append("")
                .append("&userNo=").append(orderInfo.getTradeNo())
                .append("&userType=").append("USER_ID");
        System.out.println("签名字符串："+builder.toString());
        //生成签名
        String sign=YeepayService.getSign(builder.toString());
        System.out.println("sign:"+sign);
        //响应参数
        Map<String,String>  responseMap=new HashMap<String, String>();
        responseMap.put("wxAppId","");
        responseMap.put("token",response.get("token"));
        responseMap.put("merchantNo",Configuration.getInstance().getValue("merchantNo"));
        responseMap.put("userNo",orderInfo.getTradeNo());
        responseMap.put("userType","USER_ID");
        responseMap.put("directPayType","");
        responseMap.put("cardType","");
        responseMap.put("timeStamp",String.valueOf(System.currentTimeMillis()/1000));
        responseMap.put("latitude",0+"");
        responseMap.put("longitude",0+"");
        responseMap.put("sign",sign);

        StringBuilder content=new StringBuilder();
        Set<Map.Entry<String, String>> entry = responseMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> temp = iterator.next();
            try {
				content.append(temp.getKey()).append("=").append(URLEncoder.encode(temp.getValue()==null?"":temp.getValue(),"utf-8")).append(iterator.hasNext()?"&":"");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
        }
        System.out.println(content.toString());
        return content.toString();
    }

}
