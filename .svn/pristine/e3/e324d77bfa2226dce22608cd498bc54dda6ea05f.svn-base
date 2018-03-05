package com.rw.finance.admin.dao;

import com.rw.finance.common.entity.PowerLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 权限等级Dao
 */
public interface PowerLevelDao extends JpaRepository<PowerLevel, Long> {
    /**
     * 根据运用对象查询结果
     *
     * @param levelobject
     * @return
     */
    List<PowerLevel> findByLevelobject(int levelobject);
}
