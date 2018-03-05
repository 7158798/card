package com.rw.finance.common.pass.yeepay2.agent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.rw.finance.common.pay.PayerBo;

public class PaymentQueryServlet {     
	
	public static Map<String,String> doPost(PayerBo.OrderInfo orderInfo){
		Map<String, String> params = new HashMap<>();
		params.put("customerNumber", Config.getInstance().getValue("customerNumber"));
		params.put("batchNo", orderInfo.getTradeNo().substring(orderInfo.getTradeNo().length()-15, orderInfo.getTradeNo().length()));
		//params.put("product","RJT");//为空走委托结算出款，值为RJT为日结通出款
		params.put("orderId", orderInfo.getTradeNo());
		//params.put("pageNo", pageNo);
		//params.put("pageSize", pageSize);
		String uri = Config.getInstance().getValue("paymentqueryUri");
		Map<String,String> yopresponsemap	=	YeepayService.yeepayYOP(params,uri);
		return yopresponsemap;
	}
	
	public static String format(String text){
		return text==null?"":text.trim();
	}

	/**
	 * 易宝2订单对象
	 */
	public class YeePay2Order{
		private String orderId;
		private String batchNo;
		private String transferStatusCode;
		private String bankTrxStatusCode;
		private String accountName;
		private String accountNumber;
		private String bankCode;
		private String bankName;
		private double amount;
		private double fee;
		private String feeType;
		private boolean urgency;
		private String urgencyType;
		private String finishDate;

		public String getOrderId() {
			return orderId;
		}

		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}

		public String getBatchNo() {
			return batchNo;
		}

		public void setBatchNo(String batchNo) {
			this.batchNo = batchNo;
		}

		public String getTransferStatusCode() {
			return transferStatusCode;
		}

		public void setTransferStatusCode(String transferStatusCode) {
			this.transferStatusCode = transferStatusCode;
		}

		public String getBankTrxStatusCode() {
			return bankTrxStatusCode;
		}

		public void setBankTrxStatusCode(String bankTrxStatusCode) {
			this.bankTrxStatusCode = bankTrxStatusCode;
		}

		public String getAccountName() {
			return accountName;
		}

		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public String getBankCode() {
			return bankCode;
		}

		public void setBankCode(String bankCode) {
			this.bankCode = bankCode;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public double getFee() {
			return fee;
		}

		public void setFee(double fee) {
			this.fee = fee;
		}

		public String getFeeType() {
			return feeType;
		}

		public void setFeeType(String feeType) {
			this.feeType = feeType;
		}

		public boolean isUrgency() {
			return urgency;
		}

		public void setUrgency(boolean urgency) {
			this.urgency = urgency;
		}

		public String getUrgencyType() {
			return urgencyType;
		}

		public void setUrgencyType(String urgencyType) {
			this.urgencyType = urgencyType;
		}

		public String getFinishDate() {
			return finishDate;
		}

		public void setFinishDate(String finishDate) {
			this.finishDate = finishDate;
		}
	}
}
