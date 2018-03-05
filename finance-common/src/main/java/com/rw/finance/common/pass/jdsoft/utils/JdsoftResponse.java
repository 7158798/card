package com.rw.finance.common.pass.jdsoft.utils;

public class JdsoftResponse {

	private Meta meta;
	private Data data;
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public class Meta{
		private int code;
		private String message;
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}
	public class Data{
		private double orgFee;
		private double merchantFee;
		private String url;
		public double getOrgFee() {
			return orgFee;
		}
		public void setOrgFee(double orgFee) {
			this.orgFee = orgFee;
		}
		public double getMerchantFee() {
			return merchantFee;
		}
		public void setMerchantFee(double merchantFee) {
			this.merchantFee = merchantFee;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	}
}
