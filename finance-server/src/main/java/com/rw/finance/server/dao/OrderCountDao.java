package com.rw.finance.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rw.finance.common.entity.OrderCount;

public interface OrderCountDao extends JpaRepository<OrderCount, Long>{

}
