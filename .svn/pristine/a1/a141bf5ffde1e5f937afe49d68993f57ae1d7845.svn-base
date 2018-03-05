package com.rw.finance.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rw.finance.admin.dao.LogInfoDao;
import com.rw.finance.admin.service.LogInfoService;
import com.rw.finance.common.entity.LogInfo;

@Service
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    private LogInfoDao logInfoDao;

    @Override
    public void add(LogInfo logInfo) {
        logInfoDao.save(logInfo);
    }

}
