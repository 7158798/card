package com.rw.finance.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.rw.finance.common.entity.QrCodeRegist;
import com.rw.finance.common.service.QrCodeRegistService;
import com.rw.finance.server.dao.QrCodeRegistDao;

/**
 * 
 * @file QrCodeRegistServiceImpl.java	
 * @author huanghongfei
 * @date 2017年12月28日 下午7:45:51
 * @declaration
 */
@Component
@Service(interfaceClass=QrCodeRegistService.class)
public class QrCodeRegistServiceImpl implements QrCodeRegistService{

	@Autowired
	private QrCodeRegistDao qrCodeRegistDao;
	
	@Override
	public void add(QrCodeRegist qrCodeRegist) {
		qrCodeRegistDao.save(qrCodeRegist);
	}
	
	@Override
	public QrCodeRegist getByIpaddrAndUseragent(String ipaddr,String useragent) {
		QrCodeRegist qrCodeRegist=qrCodeRegistDao.findByIpaddrAndUseragent(ipaddr, useragent);
		return qrCodeRegist;
	}
	
}
