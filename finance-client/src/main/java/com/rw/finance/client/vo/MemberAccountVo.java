package com.rw.finance.client.vo;

/**
 * 用户账户显示模型
 * @file MemberAccountVo.java	
 * @author huanghongfei
 * @date 2018年1月2日 下午1:55:07
 * @declaration
 */
public class MemberAccountVo {

	/**
	 * 账户详情
	 * @file MemberAccountVo.java	
	 * @author huanghongfei
	 * @date 2018年1月2日 下午2:01:06
	 * @declaration
	 */
	public class DetailVo{
		/**
		 * 总收入
		 */
		private double totalProfit;
		/**
		 * 本月收入
		 */
		private double curMonthProfit;
		/**
		 * 今日收入
		 */
		private double curDayProfit;
		/**
		 * 可用余额
		 */
		private double usableBalance;
		/**
		 * 锁定余额
		 */
		private double lockBalance;
		public double getTotalProfit() {
			return totalProfit;
		}
		public void setTotalProfit(double totalProfit) {
			this.totalProfit = totalProfit;
		}
		public double getCurMonthProfit() {
			return curMonthProfit;
		}
		public void setCurMonthProfit(double curMonthProfit) {
			this.curMonthProfit = curMonthProfit;
		}
		public double getCurDayProfit() {
			return curDayProfit;
		}
		public void setCurDayProfit(double curDayProfit) {
			this.curDayProfit = curDayProfit;
		}
		public double getUsableBalance() {
			return usableBalance;
		}
		public void setUsableBalance(double usableBalance) {
			this.usableBalance = usableBalance;
		}
		public double getLockBalance() {
			return lockBalance;
		}
		public void setLockBalance(double lockBalance) {
			this.lockBalance = lockBalance;
		}
	}
}
