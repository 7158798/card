package com.rw.finance.admin.dao;

import com.rw.finance.common.entity.OrderCount;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderCountDao extends PagingAndSortingRepository<OrderCount, Long>,
        JpaSpecificationExecutor<OrderCount> {
}
