package com.rw.finance.admin.dao;

import com.rw.finance.common.entity.PowerResourceLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 权限分配Dao
 */
public interface PowerResourceLevelDao extends JpaRepository<PowerResourceLevel, Long> {
    List<PowerResourceLevel> findAllByLevelid(long levelid);

    void deleteAllByLevelid(long levelid);
}
