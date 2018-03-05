package com.rw.finance.admin.dao;

import com.rw.finance.common.entity.PowerResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 资源管理Dao
 */
public interface PowerResourceDao extends JpaRepository<PowerResource, Long> {
    /**
     * 根据上级编号查询结果
     *
     * @param parentid
     * @return
     */
    List<PowerResource> findByParentid(long parentid);

    /**
     * 根据上级编号删除
     *
     * @param parentid
     */
    void deleteAllByParentid(long parentid);
}
