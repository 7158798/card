package com.rw.finance.common.constants;
/**
 * 卡片状态
 * @file MmeberCardStatusConstatns.java	
 * @author huanghongfei
 * @date 2017年12月21日 下午3:36:29
 * @declaration
 */
public class MemberCardConstatns {
	
	/**
	 * 添加贷记卡鉴权支付的金额
	 */
	public static final double AUTH_PAY_AMOUNT=1;
	/**
	 * 
	 * @file MemberCardStatusConstatns.java	
	 * @author huanghongfei
	 * @date 2017年12月22日 下午4:00:37
	 * @declaration
	 */
	public enum Status{
		/**
		 * 未鉴权
		 */
		STATUS0(0),
		/**
		 * 已鉴权
		 */
		STATUS1(1),
		/**
		 * 已停用
		 */
		STATUS2(2);
		private int status;
		Status(int status){
			this.status=status;
		}
		public int getStatus(){
			return status;
		}
	}
	/**
	 * 
	 * @file MemberCardConstatns.java	
	 * @author huanghongfei
	 * @date 2017年12月22日 下午4:04:35
	 * @declaration
	 */
	public enum Type{
		/**
		 * 借记卡
		 */
		TYPE1(1),
		/**
		 * 贷记卡
		 */
		TYPE2(2),
		/**
		 * 存折
		 */
		TYPE3(3),
		/**
		 * 公司账户
		 */
		TYPE4(4);
		private int type;
		Type(int type){
			this.type=type;
		}
		public int getType(){
			return type;
		}
	}
}
