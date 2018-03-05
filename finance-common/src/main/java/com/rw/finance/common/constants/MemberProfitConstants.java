package com.rw.finance.common.constants;

import org.springframework.stereotype.Component;
/**
 * 
 * @file MemberProfitConstants.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午5:21:16
 * @declaration
 */
@Component
public class MemberProfitConstants {
	/**
	 * 交易类型
	 * @file MemberProfitConstants.java	
	 * @author huanghongfei
	 * @date 2017年12月22日 下午5:23:31
	 * @declaration
	 */
	public enum BizType{
		/**
		 * 还款收益
		 */
		RepayTaskProfit(0),
		/**
		 * 提现
		 */
		MemberCashProfit(1),
		/**
		 * 套现
		 */
		MemberBorrowProfit(2),
		/**
		 * 激活
		 */
		MemberActiveProfit(3),
		/**
		 * 代理提现
		 */
		AgentCashProfit(4),
		/**
		 * 会员鉴权
		 */
		MemberCardProfit(5),
		/**
		 * 其他分润类型
		 */
		OtherProfit(9);
		private int bizType;
		BizType(int bizType){
			this.bizType=bizType;
		}
		public int getBizType(){
			return bizType;
		}
	}
	/**
	 * 分润等级
	 * @file MemberProfitConstants.java	
	 * @author huanghongfei
	 * @date 2017年12月22日 下午5:35:54
	 * @declaration
	 */
	public enum Level{
		/**
		 * 1级分润
		 */
		LEVEL1(1),
		/**
		 * 2级分润
		 */
		LEVEL2(2),
		/**
		 * 3级分润
		 */
		LEVEL3(3);
		private int level;
		Level(int level){
			this.level=level;
		}
		public int getLevel(){
			return level;
		}
	}

}
