package com.rw.finance.server.dao;

import com.rw.finance.common.entity.BankInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 * @file BankInfoDao.java
 * @author huanghongfei
 * @date 2017年12月12日 下午4:32:07
 * @declaration
 */
public interface BankInfoDao extends JpaRepository<BankInfo,Long>{
	
	@Query(value="select * from bank_info o where o.bank_code like %?1",nativeQuery=true)
	BankInfo findByBankcodeLike(String bankcode);
	
}
