package com.rw.finance.common.service;

import java.util.List;

import com.rw.finance.common.entity.OrderInfo;

/**
 * 
 * @file OrderInfoService.java	
 * @author huanghongfei
 * @date 2017年12月15日 上午9:51:22
 * @declaration
 */
public interface OrderInfoService {

	/**
	 * 添加
	 * @param orderInfo
	 */
	void add(OrderInfo orderInfo);
	/**
	 * 根据会员编号获取
	 * @param memberid 会员编号
	 * @return
	 */
	List<OrderInfo> listByMemberidAndType(long memberid,int type,int page,int size);
	/**
	 * 模糊查询，根据details json
	 * @param details
	 * @return
	 */
	OrderInfo getByDetailsLike(String details);
}
