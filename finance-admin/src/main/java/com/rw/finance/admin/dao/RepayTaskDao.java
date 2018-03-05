package com.rw.finance.admin.dao;

import com.rw.finance.common.entity.RepayTask;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 还款任务
 */
public interface RepayTaskDao extends JpaRepository<RepayTask, Long> {
    List<RepayTask> findAllByPlanid(Long planid, Sort sort);

    List<RepayTask> findAllByPlanidAndStatus(Long planid, Integer status, Sort sort);
}
