package com.rw.finance.client.controller;

import com.rw.finance.client.BaseTest;
import com.rw.finance.common.constants.OrderInfoConstants;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 17:37 2018/2/7
 */
public class OrderInfoControllerTest extends BaseTest{

    @Autowired
    private OrderInfoController orderInfoController;

    @Test
    public void listByMemberidAndType(){
        Object obj=orderInfoController.listByMemberidAndType(31, OrderInfoConstants.Type.RepayTaskOrder.getType(),0,100).getData();
        System.out.println(obj);
    }
}
