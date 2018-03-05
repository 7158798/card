package com.rw.finance.common.service;

import java.util.List;

import com.rw.finance.common.entity.MemberProfit;

/**
 * 
 * @file MemberProfitService.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午4:46:21
 * @declaration
 */
public interface MemberProfitService {

	/**
	 * 添加
	 * @param memberProfit
	 */
	void add(MemberProfit memberProfit);
	/**
	 * 根据会员编号和分润等级获取分润列表
	 * @param memberid
	 * @param level
	 * @return
	 */
	List<MemberProfit> listByMemberidAndLevel(long memberid,int level,int page,int size);
	/**
	 * 根据会员编号获取分润列表
	 * @param memberid
	 * @param level
	 * @return
	 */
	List<MemberProfit> listByMemberid(long memberid,int page,int size);
	/**
	 * 统计会员编号分组分润等级
	 * @param memberid
	 * @return
	 */
	List<Object[]> countByMemberidGroupLevel(long memberid);
	/**
	 * 根据日期获取当日总收益
	 * @param memberid
	 * @param day
	 * @return
	 */
	double sumProfitByMemberidAndDate(long memberid,String date);
	/**
	 * 根据月份获取当月总收益
	 * @param memberid
	 * @param month
	 * @return
	 */
	double sumProfitByMemberidAndMonth(long memberid,String month);
	/**
	 * 统计所有收益
	 * @param memberid
	 * @return
	 */
	double sumProfitByMemberid(long memberid);
}
