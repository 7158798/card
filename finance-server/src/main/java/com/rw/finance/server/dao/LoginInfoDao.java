package com.rw.finance.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rw.finance.common.entity.LoginInfo;
/**
 * 
 * @file LoginInfoDao.java	
 * @author huanghongfei
 * @date 2017年12月23日 下午6:21:45
 * @declaration
 */
public interface LoginInfoDao extends JpaRepository<LoginInfo, Long>{

}
