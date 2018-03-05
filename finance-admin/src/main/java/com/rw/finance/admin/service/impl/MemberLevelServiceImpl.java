package com.rw.finance.admin.service.impl;

import com.rw.finance.admin.dao.MemberLevelDao;
import com.rw.finance.admin.service.MemberLevelService;
import com.rw.finance.common.entity.MemberLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberLevelServiceImpl implements MemberLevelService {
    @Autowired
    private MemberLevelDao memberLevelDao;

    @Override
    public List<MemberLevel> getMemberLevels() {
        return memberLevelDao.findAll(new Sort(Sort.Direction.ASC, "level"));
    }
}
