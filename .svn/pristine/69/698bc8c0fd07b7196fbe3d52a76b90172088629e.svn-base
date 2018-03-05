package com.rw.finance.common.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class BankUtils {
	/**
     * 根据银行卡号获取银行信息
     * @param strUrl 访问地址
     * @param param 参数字符串
     * */
    public static BankInfo getBankInfo(String cardNo) {
    	String strUrl="https://v.apistore.cn/api/c43";
    	String apiKey="83dc0da9e576d44226ebd0360bd1b4b7";
        String returnStr = null; // 返回结果定义
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        String params="key="+apiKey+"&bankcard="+cardNo;
        try {
            url = new URL(strUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST"); // post方式
            httpURLConnection.connect();
            byte[] byteParam = params.getBytes("UTF-8");
            DataOutputStream out = new DataOutputStream(httpURLConnection.getOutputStream());
            out.write(byteParam);
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
 
            reader.close();
            returnStr = buffer.toString();
            System.err.println(returnStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return new Gson().fromJson(returnStr, BankInfo.class);
    }
    /**
     * 获取银行信息结果对象
     * @file BankUtils.java	
     * @author huanghongfei
     * @date 2018年1月9日 下午5:39:43
     * @declaration
     */
    public class BankInfo{
    	private int error_code;
    	private String reason;
    	private Result result;
    	public class Result{
    		private String bankname;
    		private String banknum;
    		private String cardprefixnum;
    		private String cardname;
    		private String cardtype;
    		private String cardprefixlength;
    		private boolean isLuhn;
    		private String bankurl;
    		private String enbankname;
    		private String abbreviation;
    		private String bankimage;
    		private String servicephone;
    		private String province;
    		private String city;
			public String getBankname() {
				return bankname;
			}
			public void setBankname(String bankname) {
				this.bankname = bankname;
			}
			public String getBanknum() {
				return banknum;
			}
			public void setBanknum(String banknum) {
				this.banknum = banknum;
			}
			public String getCardprefixnum() {
				return cardprefixnum;
			}
			public void setCardprefixnum(String cardprefixnum) {
				this.cardprefixnum = cardprefixnum;
			}
			public String getCardname() {
				return cardname;
			}
			public void setCardname(String cardname) {
				this.cardname = cardname;
			}
			public String getCardtype() {
				return cardtype;
			}
			public void setCardtype(String cardtype) {
				this.cardtype = cardtype;
			}
			public String getCardprefixlength() {
				return cardprefixlength;
			}
			public void setCardprefixlength(String cardprefixlength) {
				this.cardprefixlength = cardprefixlength;
			}
			public boolean isLuhn() {
				return isLuhn;
			}
			public void setLuhn(boolean isLuhn) {
				this.isLuhn = isLuhn;
			}
			public String getBankurl() {
				return bankurl;
			}
			public void setBankurl(String bankurl) {
				this.bankurl = bankurl;
			}
			public String getEnbankname() {
				return enbankname;
			}
			public void setEnbankname(String enbankname) {
				this.enbankname = enbankname;
			}
			public String getAbbreviation() {
				return abbreviation;
			}
			public void setAbbreviation(String abbreviation) {
				this.abbreviation = abbreviation;
			}
			public String getBankimage() {
				return bankimage;
			}
			public void setBankimage(String bankimage) {
				this.bankimage = bankimage;
			}
			public String getServicephone() {
				return servicephone;
			}
			public void setServicephone(String servicephone) {
				this.servicephone = servicephone;
			}
			public String getProvince() {
				return province;
			}
			public void setProvince(String province) {
				this.province = province;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
    	}
		public int getError_code() {
			return error_code;
		}
		public void setError_code(int error_code) {
			this.error_code = error_code;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		public Result getResult() {
			return result;
		}
		public void setResult(Result result) {
			this.result = result;
		}
    }
    /**
     * 银行卡4要素验证
     * @param strUrl 访问地址
     * @param param 参数字符串
     * */
    public static AuthResult auth(CardInfo cardInfo) {
    	String apiKey="dd5972f972508290b188d10ce48e41a7";
        String returnStr = null; // 返回结果定义
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        String strUrl="https://v.apistore.cn/api/bank/v4";
        String param="key="+apiKey+"&bankcard="+cardInfo.getBankcard()+"&realName="+cardInfo.getRealName()+"&cardNo="+cardInfo.getCardNo()+"&Mobile="+cardInfo.getMobile()+"&cardtype=&information=";
        try {
            url = new URL(strUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST"); // post方式
            httpURLConnection.connect();
            byte[] byteParam = param.getBytes("UTF-8");
            DataOutputStream out = new DataOutputStream(httpURLConnection.getOutputStream());
            out.write(byteParam);
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
 
            reader.close();
            returnStr = buffer.toString();
            System.err.println(returnStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return new Gson().fromJson(returnStr,AuthResult.class);
    }
    /*public static void main(String []orgs){
    	System.err.println(1);
    	AuthResult result=BankUtils.auth(new BankUtils().new CardInfo("6221516530008644030", "黄洪飞", "500221199210021718", ""));
    	System.err.println(result);
    }*/
    /**
     * 银行卡四元认证参数对象
     * @file BankUtils.java	
     * @author huanghongfei
     * @date 2018年1月9日 下午5:41:46
     * @declaration
     */
    public class CardInfo{
    	public CardInfo(String bankcard,String realName,String cardNo,String mobile){
    		this.bankcard=bankcard;
    		this.realName=realName;
    		this.cardNo=cardNo;
    		this.mobile=mobile;
    	}
    	/**
    	 * 银行卡卡号
    	 */
    	private String bankcard;
    	/**
    	 * 真实姓名
    	 */
    	private String realName;
    	/**
    	 * 身份证号
    	 */
    	private String cardNo;
    	/**
    	 * 手机号
    	 */
    	private String mobile;
		public String getBankcard() {
			return bankcard;
		}
		public void setBankcard(String bankcard) {
			this.bankcard = bankcard;
		}
		public String getRealName() {
			return realName;
		}
		public void setRealName(String realName) {
			this.realName = realName;
		}
		public String getCardNo() {
			return cardNo;
		}
		public void setCardNo(String cardNo) {
			this.cardNo = cardNo;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
    }
    /**
     * 银行卡4元认证结果对象
     * @file BankUtils.java	
     * @author huanghongfei
     * @date 2018年1月9日 下午5:49:58
     * @declaration
     */
    public class AuthResult{
    	private int error_code;
    	private String reason;
    	private Result result;
    	private String ordersign;
		public Result getResult() {
			return result;
		}
		public void setResult(Result result) {
			this.result = result;
		}
		public String getOrdersign() {
			return ordersign;
		}
		public void setOrdersign(String ordersign) {
			this.ordersign = ordersign;
		}
		public int getError_code() {
			return error_code;
		}
		public void setError_code(int error_code) {
			this.error_code = error_code;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		public class Result{
			private String bankcard;
			private String realName;
			private String cardNo;
			private String mobile;
			public String getBankcard() {
				return bankcard;
			}
			public void setBankcard(String bankcard) {
				this.bankcard = bankcard;
			}
			public String getRealName() {
				return realName;
			}
			public void setRealName(String realName) {
				this.realName = realName;
			}
			public String getCardNo() {
				return cardNo;
			}
			public void setCardNo(String cardNo) {
				this.cardNo = cardNo;
			}
			public String getMobile() {
				return mobile;
			}
			public void setMobile(String mobile) {
				this.mobile = mobile;
			}
		}
    }
}
