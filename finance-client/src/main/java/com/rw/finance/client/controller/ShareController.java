package com.rw.finance.client.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rw.finance.client.config.SystemSetting;
import com.rw.finance.common.entity.AgentInfo;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.pass.yeepay2.YeepayService;
import com.rw.finance.common.pay.PayResult;
import com.rw.finance.common.pay.PayerBo;
import com.rw.finance.common.pay.YeeBao2Payer;
import com.rw.finance.common.service.AgentInfoService;
import com.rw.finance.common.service.MemberInfoService;
import com.rw.finance.common.utils.HttpUtils;
import com.rw.finance.common.utils.QrCodeUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * @author huanghongfei
 * @file QrCodeController.java
 * @date 2018年1月3日 上午11:09:03
 * @declaration
 */
@Controller
@RequestMapping(value = "/share")
public class ShareController {

    @Autowired
    private SystemSetting systemSetting;
    @Reference
    private MemberInfoService memberInfoService;
    @Reference
    private AgentInfoService agentInfoService;

    /**
     * 会员分享二维码,不能加登录校验，代理分享会失败
     *
     * @param memberid
     * @return
     */
    @RequestMapping(value = "/qrCode", method = RequestMethod.GET)
    public void qrCode(@RequestParam(value="agentid",required=false,defaultValue="0") long agentid,
    		@RequestParam(value="memberid",required=false,defaultValue="0")long memberid,
    		HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	MemberInfo memberInfo=memberInfoService.getByMemberid(memberid);
    	String telephone="";
    	if(!StringUtils.isEmpty(memberInfo)){
    		telephone=memberInfo.getTelephone();
    	}else{
    		AgentInfo agentInfo=agentInfoService.getByAgentid(agentid);
    		if(!StringUtils.isEmpty(agentInfo)){
    			telephone=agentInfo.getMobile();
    		}
    	}
        BufferedImage image = QrCodeUtils.createQrCode(systemSetting.QR_CODE_SHARE_URL_REQUEST()+"?&memberid="+memberid+"&agentid="+agentid,telephone);
        response.setContentType("image/jpg");
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
    /**
     * 
     * @param orderid 订单编号
     * @param amount 订单金额
     * @param appId appId
     * @param openId 微信openId
     * @param productname 产品名称
     * @param productdesc 产品描述
     * @param callbackurl 回调地址
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/pay")
    public String pay(@RequestParam(value="orderid",required=false)String orderid,
    		@RequestParam(value="amount")double amount,
    		@RequestParam(value="productname")String productname,
    		@RequestParam(value="productdesc")String productdesc,
    		@RequestParam(value="fcallbackurl")String fcallbackurl){
    	PayerBo.OrderInfo orderInfo=new PayerBo().new OrderInfo(orderid, "", amount,"http://api.rongyaozhixin.com/share/payBack","");
    	orderInfo.setBeforeBackUrl(fcallbackurl);
    	orderInfo.getProductInfo().setName(productname);
    	orderInfo.getProductInfo().setDetails(productdesc);
    	PayResult payResult=new YeeBao2Payer().pay(new PayerBo().new UserInfo("", ""), 
    			new PayerBo().new CardInfo("", "", "", "", "", "", "", ""), 
    			orderInfo, 
    			new PayerBo().new PayInfo("", "", ""));
    	return payResult.getDetails();
    }
    /**
	 * 外部易宝支付回调
	 * @return
	 */
	@RequestMapping(value="/payBack")
	public String payBack(@RequestParam(value="response")String response,
			@RequestParam(value="customerIdentification")String customerIdentification){
		Map<String,String> data=YeepayService.callback(response);
		String ret="";
		try {
			ret=HttpUtils.getInstance().httpPost("http://shop.as528.com/m-weixin/payment/notify1",data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
