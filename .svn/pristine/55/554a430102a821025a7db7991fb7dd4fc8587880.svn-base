package com.rw.finance.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.entity.BankInfo;
import com.rw.finance.common.service.BankInfoService;
import com.rw.finance.server.dao.BankInfoDao;

/**
 * 
 * @file BankInfoServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月14日 上午11:53:32
 * @declaration
 */
@Component
@Service(interfaceClass=BankInfoService.class)
public class BankInfoServiceImpl implements BankInfoService{

	@Autowired
	private BankInfoDao bankInfoDao;

	@Cacheable
	public List<BankInfo> list() {
		return bankInfoDao.findAll();
	}

	@Cacheable
	public BankInfo getByBankid(long bankid) {
		return bankInfoDao.findOne(bankid);
	}

	@Override
	public BankInfo getByBankcodeLike(String bankCode) {
		return bankInfoDao.findByBankcodeLike(bankCode);
	}

}
