package com.rw.finance.server.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rw.finance.common.entity.PayChannel;

public interface PayChannelDao extends JpaRepository<PayChannel, Long>{

	PayChannel findByIsdef(int isdef);

	List<PayChannel> findByIsenable(int isenable);
}
