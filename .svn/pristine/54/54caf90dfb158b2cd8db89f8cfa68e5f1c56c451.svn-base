package com.rw.finance.admin.dao;

import com.rw.finance.common.entity.SystemSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemSettingDao extends JpaRepository<SystemSetting, Long> {
    SystemSetting findByDictkeyAndStatus(String key, int status);
}
