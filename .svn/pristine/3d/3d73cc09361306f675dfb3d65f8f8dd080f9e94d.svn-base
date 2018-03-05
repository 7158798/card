package com.rw.finance.server.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rw.finance.common.entity.OrderInfo;
/**
 * 
 * @file OrderInfoDao.java	
 * @author huanghongfei
 * @date 2017年12月15日 下午2:12:27
 * @declaration
 */
public interface OrderInfoDao extends JpaRepository<OrderInfo,Long>{
	
	Page<OrderInfo> findByUseridAndType(long userid,int type,Pageable pageable);
	
	OrderInfo findByTradeno(String tradeno);
	
	@Query(value="select * from order_info o where o.details like %?1%",nativeQuery=true)
	OrderInfo findByDetailsLike(String details);
}
