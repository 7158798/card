package com.rw.finance.common.service;

import com.rw.finance.common.entity.LogInfo;

/**
 * 操作日志接口
 * @file ProxyLogService.java	
 * @author huanghongfei
 * @date 2017年12月12日 上午9:52:29
 * @declaration
 */
public interface LogInfoService{
	
	/**\
	 * 添加操作日志
	 * @param proxyLog
	 */
	void add(LogInfo logInfo);
}
