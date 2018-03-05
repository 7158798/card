package com.rw.finance.task.task;

import com.rw.finance.task.BaseTest;
import com.rw.finance.task.utils.BeanService;
import com.rw.finance.task.utils.SpringUtil;
import org.junit.Test;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 14:45 2018/2/28
 */
public class RepayPlanThreadTest extends BaseTest{

    @Test
    public void incr(){
        for(int i=0;i<10;i++){
            System.err.println(SpringUtil.getBean(BeanService.class).baseCacheService.incr("REPAY_TASK_SYNC_1"));
        }

    }
}
