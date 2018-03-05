package com.rw.finance.common.constants;
/**
 * 
 * @file PayChannelConstants.java	
 * @author huanghongfei
 * @date 2018年2月2日 下午4:45:19
 * @declaration
 */
public class PayChannelConstants {

	/**
	 * 支付回调模式
	 * @file PayChannelConstants.java	
	 * @author huanghongfei
	 * @date 2018年2月2日 下午4:45:35
	 * @declaration
	 */
	public enum Backmode{
		/**
		 * 仅前端回调
		 */
		CLIENT(1),
		/**
		 * 仅后端回调
		 */
		SERVER(2),
		/**
		 * 前后端回调
		 */
		CLIENT_SERVER(3);
		private int mode;
		Backmode(int mode){
			this.mode=mode;
		}
		public int getMode(){
			return mode;
		}
	}
}
