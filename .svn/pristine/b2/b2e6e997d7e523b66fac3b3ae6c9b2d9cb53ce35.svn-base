package com.rw.finance.admin.service.impl;

import com.rw.finance.admin.dao.RepayTaskDao;
import com.rw.finance.admin.service.RepayTaskService;
import com.rw.finance.common.entity.RepayTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepayTaskServiceImpl implements RepayTaskService {
    @Autowired
    private RepayTaskDao repayTaskDao;

    @Override
    public List<RepayTask> getRepayTasks(Long planid, Integer status) {
        if (status == null || status == 99) {
            return repayTaskDao.findAllByPlanid(planid, new Sort(Sort.Direction.ASC, "currentstage"));
        } else {
            return repayTaskDao.findAllByPlanidAndStatus(planid, status, new Sort(Sort.Direction.ASC, "currentstage"));
        }
    }
}
