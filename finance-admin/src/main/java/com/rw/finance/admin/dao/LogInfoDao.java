package com.rw.finance.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rw.finance.common.entity.LogInfo;

/**
 * 操作日志数据访问
 * @file LogInfoDao.java	
 * @author huanghongfei
 * @date 2017年12月12日 上午10:02:23
 * @declaration
 */
public interface LogInfoDao extends JpaRepository<LogInfo,Long>{

}
