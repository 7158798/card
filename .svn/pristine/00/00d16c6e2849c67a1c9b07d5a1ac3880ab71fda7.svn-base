package com.rw.finance.client.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 分享页面统计的显示对象
 * @file MemberProfitCountVo.java	
 * @author huanghongfei
 * @date 2017年12月23日 上午10:00:39
 * @declaration
 */
public class MemberProfitVo {
	
	/**
	 * 分享页面的显示模型
	 * @file MemberProfitVo.java	
	 * @author huanghongfei
	 * @date 2017年12月27日 下午5:08:48
	 * @declaration
	 */
	public class MemberProfitCountVo{
		/**
		 * 总收益
		 */
		private double totalProfit;
		/**
		 * 今日收益
		 */
		private double toDayProfit;
		/**
		 * 昨日收益
		 */
		private double yesterDayProfit;
		/**
		 * 等级数据数组
		 */
		private List<ProfitLevel> profitLevels=new ArrayList<ProfitLevel>(3);
		/**
		 * 等级数据
		 * @file MemberProfitCountVo.java	
		 * @author huanghongfei
		 * @date 2017年12月23日 上午10:08:22
		 * @declaration
		 */
		public class ProfitLevel{
			
			public ProfitLevel(double levelProfit,double levelTotalBizAmount,long levelMemberCount){
				this.levelProfit=levelProfit;
				this.levelTotalBizAmount=levelTotalBizAmount;
				this.levelMemberCount=levelMemberCount;
			}
			/**
			 * 总收益
			 */
			private double levelProfit;
			/**
			 * 总交易金额
			 */
			private double levelTotalBizAmount;
			/**
			 * 推荐人数
			 */
			private long levelMemberCount;
			public double getLevelProfit() {
				return levelProfit;
			}
			public void setLevelProfit(double levelProfit) {
				this.levelProfit = levelProfit;
			}
			public double getLevelTotalBizAmount() {
				return levelTotalBizAmount;
			}
			public void setLevelTotalBizAmount(double levelTotalBizAmount) {
				this.levelTotalBizAmount = levelTotalBizAmount;
			}
			public long getLevelMemberCount() {
				return levelMemberCount;
			}
			public void setLevelMemberCount(long levelMemberCount) {
				this.levelMemberCount = levelMemberCount;
			}
		}
		public double getTotalProfit() {
			return totalProfit;
		}
		public void setTotalProfit(double totalProfit) {
			this.totalProfit = totalProfit;
		}
		public double getToDayProfit() {
			return toDayProfit;
		}
		public void setToDayProfit(double toDayProfit) {
			this.toDayProfit = toDayProfit;
		}
		public double getYesterDayProfit() {
			return yesterDayProfit;
		}
		public void setYesterDayProfit(double yesterDayProfit) {
			this.yesterDayProfit = yesterDayProfit;
		}
		public List<ProfitLevel> getProfitLevels() {
			return profitLevels;
		}
		public void setProfitLevels(List<ProfitLevel> profitLevels) {
			this.profitLevels = profitLevels;
		}

	}
	
}
