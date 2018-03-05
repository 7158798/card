package com.rw.finance.common.service;

import com.rw.finance.common.entity.PowerLevel;

/**
 * 
 * @file PowerLevelService.java	
 * @author huanghongfei
 * @date 2017年12月26日 下午8:30:44
 * @declaration
 */
public interface PowerLevelService {
	
	/**
	 * 根据编号获取
	 * @param levelid
	 * @return
	 */
	PowerLevel getByLevelid(long levelid);
}
