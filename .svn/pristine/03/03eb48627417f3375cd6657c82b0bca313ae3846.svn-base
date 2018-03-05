package com.rw.finance.common.constants;
/**
 * 
 * @file RepayPlanConstants.java	
 * @author huanghongfei
 * @date 2017年12月18日 下午5:33:05
 * @declaration
 */
public class RepayPlanConstants {
	/**
	 * 每日生成自动还款开始小时数
	 */
	public static final int DAY_PLAN_BEGIN_HOUR=8;
	/**
	 * 每日自动生成计划数，每日最后一个计划为还款计划，其余则为扣款计划
	 */
	public static final int DAY_REPAY_COUNT=3;
	/**
	 * 执行计划
	 */
	public static final String REPAY_PLAN_EXECUTE="REPAY_PLAN_EXECUTE";
	/**
	 * 取消计划
	 */
	public static final String REPAY_PLAN_CANCEL="REPAY_PLAN_CANCEL";
	/**
	 * 计划类型
	 * @file RepayPlanConstants.java	
	 * @author huanghongfei
	 * @date 2017年12月27日 下午4:18:03
	 * @declaration
	 */
	public enum Type{
		/**
		 * 还款计划类型：扣款
		 */
		TYPE0(0),
		/**
		 * 还款计划类型：还款
		 */
		TYPE1(1),
		/**
		 * 还款计划类型：提现
		 */
		TYPE3(2);
		private int type;
		Type(int type){
			this.type=type;
		}
		public int getType(){
			return type;
		}
	}
	/**
	 * 计划状态
	 * @file RepayPlanConstants.java	
	 * @author huanghongfei
	 * @date 2017年12月27日 下午4:19:30
	 * @declaration
	 */
	public enum Status{
		/**
		 * 未执行
		 */
		STATUS0(0),
		/**
		 * 执行中
		 */
		STATUS1(1),
		/**
		 * 已取消
		 */
		STATUS2(2),
		/**
		 * 已失败
		 */
		STATUS3(3),
		/**
		 * 已完成
		 */
		STATUS9(9);
		private int status;
		Status(int status){
			this.status=status;
		}
		public int getStatus(){
			return status;
		}
	}

}
