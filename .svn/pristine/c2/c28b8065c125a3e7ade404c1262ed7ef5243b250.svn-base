package com.rw.finance.client.vo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import nl.bitwalker.useragentutils.UserAgent;

/**
 * 
 * @file MemberInfoVo.java	
 * @author huanghongfei
 * @date 2017年12月28日 下午8:14:23
 * @declaration
 */
public class MemberInfoVo {

	/**
	 * 分享记录显示模型
	 * @file MemberInfoVo.java	
	 * @author huanghongfei
	 * @date 2018年1月2日 上午10:16:26
	 * @declaration
	 */
	public class ShareCountVo{
		/**
		 * 总分享人数
		 */
		private int totalCount;
		/**
		 * 实名人数
		 */
		private int isRealCount;
		/**
		 * 激活人数
		 */
		private int levelCount;
		/**
		 * 本月分享人数
		 */
		private int curMonthShareCount;
		/**
		 * 本月实名人数
		 */
		private int curMonthIsRealCount;
		/**
		 * 本月激活人数
		 */
		private int curMonthLevelCount;
		/**
		 * 月份：分享会员信息列表分组
		 */
		Map<String,List<MemberInfo>> all=new LinkedHashMap<String,List<MemberInfo>>();
		public int getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}
		public int getIsRealCount() {
			return isRealCount;
		}
		public void setIsRealCount(int isRealCount) {
			this.isRealCount = isRealCount;
		}
		public int getLevelCount() {
			return levelCount;
		}
		public void setLevelCount(int levelCount) {
			this.levelCount = levelCount;
		}
		public int getCurMonthShareCount() {
			return curMonthShareCount;
		}
		public void setCurMonthShareCount(int curMonthShareCount) {
			this.curMonthShareCount = curMonthShareCount;
		}
		public int getCurMonthIsRealCount() {
			return curMonthIsRealCount;
		}
		public void setCurMonthIsRealCount(int curMonthIsRealCount) {
			this.curMonthIsRealCount = curMonthIsRealCount;
		}
		public int getCurMonthLevelCount() {
			return curMonthLevelCount;
		}
		public void setCurMonthLevelCount(int curMonthLevelCount) {
			this.curMonthLevelCount = curMonthLevelCount;
		}
		public Map<String, List<MemberInfo>> getAll() {
			return all;
		}
		public void setAll(Map<String, List<MemberInfo>> all) {
			this.all = all;
		}
		public class MemberInfo{
			public MemberInfo(String telephone,int isReal,String date){
				this.telephone=telephone;
				this.isReal=isReal;
				this.date=date;
			}
			/**
			 * 受邀会员手机号
			 */
			private String telephone;
			/**
			 * 是否实名认证
			 */
			private int isReal;
			/**
			 * 注册日期
			 */
			private String date;
			public String getTelephone() {
				return telephone;
			}
			public void setTelephone(String telephone) {
				this.telephone = telephone;
			}
			public int getIsReal() {
				return isReal;
			}
			public void setIsReal(int isReal) {
				this.isReal = isReal;
			}
			public String getDate() {
				return date;
			}
			public void setDate(String date) {
				this.date = date;
			}
		}
	}
	/**
	 * user-agent
	 * @file MemberInfoVo.java	
	 * @author huanghongfei
	 * @date 2018年1月3日 下午3:46:07
	 * @declaration
	 */
	public class UserAgentUtils{
		private String userAgent;
		public UserAgentUtils(String userAgent){
			this.userAgent=userAgent;
		}
		public String getUserAgentInfo(){
			UserAgent uA = UserAgent.parseUserAgentString(userAgent); 
			return uA.getOperatingSystem().getDeviceType()+"/"+uA.getOperatingSystem().getName();
		}
	}
}
