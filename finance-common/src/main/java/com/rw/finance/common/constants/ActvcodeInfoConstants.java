package com.rw.finance.common.constants;

/**
 * 
 * @file ActvcodeInfoConstants.java	
 * @author huanghongfei
 * @date 2017年12月28日 上午10:00:15
 * @declaration
 */
public class ActvcodeInfoConstants {

	/**
	 * 激活码使用状态
	 * @file ActvcodeInfoConstants.java	
	 * @author huanghongfei
	 * @date 2017年12月28日 上午10:02:33
	 * @declaration
	 */
	public enum UseStatus{
		/**
		 * 待用
		 */
		STATUS1(1),
		/**
		 * 已用
		 */
		STATUS2(2),
		/**
		 * 停用
		 */
		STATUS3(3);
		private int status;
		UseStatus(int status){
			this.status=status;
		}
		public int getStatus(){
			return status;
		}
	}
}
