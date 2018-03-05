package com.rw.finance.common.service;

import com.rw.finance.common.entity.QrCodeRegist;

/**
 * 
 * @file QrcodeRegistService.java	
 * @author huanghongfei
 * @date 2017年12月28日 下午7:43:32
 * @declaration
 */
public interface QrCodeRegistService {
	
	/**
	 * 添加
	 * @param qrCodeRegist
	 */
	void add(QrCodeRegist qrCodeRegist);
	/**
	 * 根据ip地址和UserAgent获取扫描二维码信息
	 * @param ipaddr
	 * @param useragent
	 * @return
	 */
	QrCodeRegist getByIpaddrAndUseragent(String ipaddr,String useragent);
}
