package com.rw.finance.common.constants;
/**
 * 
 * @file OrderInfoConstants.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午3:09:21
 * @declaration
 */
public class OrderInfoConstants {

	/**
	 * 订单类型
	 * @file OrderInfoConstants.java	
	 * @author huanghongfei
	 * @date 2017年12月22日 下午3:11:14
	 * @declaration
	 */
	public enum Type{
		/**
		 * 代还订单
		 */
		RepayTaskOrder(0),
		/**
		 * 提现订单
		 */
		MemberCashOrder(1),
		/**
		 * 收款订单
		 */
		MemberBorrowOrder(2),
		/**
		 * 会员激活订单
		 */
		MemberActiveOrder(3),
		/**
		 * 代理提现订单
		 */
		AgentCashOrder(4),
		/**
		 * 添加贷记卡支付鉴权订单
		 */
		MemberCardOrder(5),
		/**
		 * 其他订单
		 */
		OtherOrder(9);
		private int type;
		Type(int type){
			this.type=type;
		}
		public int getType(){
			return type;
		}
	}
	/**
	 * 订单状态
	 * @file OrderInfoConstants.java	
	 * @author huanghongfei
	 * @date 2017年12月22日 下午3:12:46
	 * @declaration
	 */
	public enum Status{
		//创建
		STATUS0(0),
		//成功
		STATUS1(1),
		//失败
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
	 * 订单编号生成前缀，根据前缀来决定是什么订单
	 * @file OrderInfoConstants.java	
	 * @author huanghongfei
	 * @date 2017年12月23日 下午5:40:07
	 * @declaration
	 */
	public enum Prefix{
		/**
		 * 代还订单
		 */
		RepayTaskOrder("0"),
		/**
		 * 提现订单
		 */
		MemberCashOrder("1"),
		/**
		 * 收款订单
		 */
		MemberBorrowOrder("2"),
		/**
		 * 会员激活订单
		 */
		MemberActiveOrder("3"),
		/**
		 * 代理提现订单
		 */
		AgentCashOrder("4"),
		/**
		 * 添加贷记卡支付鉴权订单
		 */
		MemberCardOrder("5"),
		/**
		 * 其他订单
		 */
		OtherOrder("9");
		private String prefix;
		Prefix(String prefix){
			this.prefix=prefix;
		}
		public String getPrefix(){
			return prefix;
		}
	}
}
