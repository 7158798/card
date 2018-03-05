package com.rw.finance.client.controller;

import com.rw.finance.client.BaseTest;
import com.rw.finance.client.vo.SystemVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 15:48 2018/2/10
 */
public class SystemControllerTest extends BaseTest{

    @Autowired
    private SystemController systemController;

    @Test
    public void checkVersion(){
        SystemVo.Version version=systemController.checkVersion();
        System.out.println(version);
    }
}
