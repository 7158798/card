package com.rw.finance.admin.dao;

import com.rw.finance.common.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OrderInfoDao extends PagingAndSortingRepository<OrderInfo, Long>, JpaSpecificationExecutor<OrderInfo> {
    @Query(value = "select sum(orderamount) from OrderInfo where status = ?1")
    Double sumByStatus(Integer status);

    @Query(value = "select sum(orderamount) from OrderInfo where status = ?1 and ((userid = ?2 and type = 4) or " +
            "(userid in ?3 and type in (0,1,2,3)))")
    Double sumByStatusAndAgentid(Integer status, Long agentid, List<Long> id);

    OrderInfo findByTradenoAndOuttradeno(String tradeno, String outtradeno);
}
