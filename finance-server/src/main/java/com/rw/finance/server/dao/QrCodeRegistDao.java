package com.rw.finance.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rw.finance.common.entity.QrCodeRegist;
/**
 * 
 * @file QrCodeRegistDao.java	
 * @author huanghongfei
 * @date 2017年12月28日 下午7:47:07
 * @declaration
 */
public interface QrCodeRegistDao extends JpaRepository<QrCodeRegist, Long>{

	@Query(value="select * from qrcode_regist as o where o.regist_id=(select max(regist_id) from qrcode_regist where ip_addr=?1 and user_agent=?2)",nativeQuery=true)
	QrCodeRegist findByIpaddrAndUseragent(String ipaddr,String useragent);
}
