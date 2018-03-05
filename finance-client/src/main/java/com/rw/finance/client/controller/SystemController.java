package com.rw.finance.client.controller;

import com.rw.finance.client.config.SystemSetting;
import com.rw.finance.client.vo.SystemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 15:22 2018/2/10
 */
@RestController
@RequestMapping()
public class SystemController {

    @Autowired
    private SystemSetting systemSetting;
    /**
     * 版本检查
     * @return version info
     */
    @RequestMapping(value="/check/version")
    public SystemVo.Version checkVersion(){
        return systemSetting.APP_LAST_VERSION();
    }
}
