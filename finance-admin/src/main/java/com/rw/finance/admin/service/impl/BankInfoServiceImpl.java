package com.rw.finance.admin.service.impl;

import com.rw.finance.admin.dao.BankInfoDao;
import com.rw.finance.admin.service.BankInfoService;
import com.rw.finance.admin.service.BaseCacheService;
import com.rw.finance.common.constants.TimeConstants;
import com.rw.finance.common.entity.BankInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankInfoServiceImpl implements BankInfoService {
    @Autowired
    private BankInfoDao bankInfoDao;

    @Autowired
    private BaseCacheService baseCacheService;

    @Override
    public List<BankInfo> getBankInfos(int status) {
        // 缓存对象
        List<BankInfo> list = null;
        Object object = baseCacheService.get("BANK_LIST", List.class);
        if (object == null) {
            list = this.bankInfoDao.findAll();
            baseCacheService.set("BANK_LIST", list, TimeConstants.SMS_CODE_EXPRIE_TIME);
        } else {
            list = (List<BankInfo>) object;
        }

        return list;
    }
}
