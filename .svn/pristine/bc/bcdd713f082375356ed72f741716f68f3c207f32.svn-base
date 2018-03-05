package com.rw.finance.admin.controller;


import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.service.BankInfoService;
import com.rw.finance.common.entity.BankInfo;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 银行信息
 */
@RestController
@RequestMapping(value = "/bank")
public class BankInfoController {
    @Autowired
    private BankInfoService bankInfoService;

    /**
     * 获取银行列表
     *
     * @param status
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getbankinfos")
    public Result getBankInfos(@RequestParam(value = "status", required = true) Integer status) {
        List<BankInfo> data = bankInfoService.getBankInfos(status);
        return new Result(200, null, data);
    }
}
