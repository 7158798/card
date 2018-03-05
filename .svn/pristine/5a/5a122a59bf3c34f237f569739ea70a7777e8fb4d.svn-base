package com.rw.finance.admin.controller;

import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.service.AgentAccountService;
import com.rw.finance.common.utils.Result;
import com.rw.finance.common.utils.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 代理账户
 *
 * @author huanghongfei
 * @file AgentAccountConstroller.java
 * @date 2017年12月25日 上午10:05:10
 * @declaration
 */
@RestController
@RequestMapping(value = "/agentaccount")
public class AgentAccountController {
    @Autowired
    private AgentAccountService agentAccountService;

    /**
     * 获取提现短信验证码
     *
     * @param telephone 手机号
     * @return 短信验证码
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getoutcashcode")
    public Result<Object> getOutcashCode(@RequestParam(value = "telephone", required = true) String telephone) {
        // 验证码
        String code = SmsUtils.smsCodeGenerator();

        // 发送短信
        boolean isSuccess = SmsUtils.send(telephone, code);
        return new Result<Object>(200, null, code);
    }

    /**
     * 提交提现申请
     *
     * @param agentid
     * @param amount
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/savecashapply")
    public Result saveCashApply(@RequestAttribute(value = "agentid", required = true) Long agentid, @RequestParam
            (value = "amount", required = true) Double amount, @RequestParam
                                        (value = "cardid", required = true) Long cardid) {
        if (agentid == null || agentid <= 0) {
            return new Result(202, "代理编号不能为空", null);
        }

        if (amount == null || amount <= 0) {
            return new Result(202, "提现金额必须大于0", null);
        }

        if (cardid == null || cardid <= 0) {
            return new Result(202, "银行卡编号不能为空", null);
        }

        // 提交申请
        Result result = agentAccountService.applyCash(agentid, amount, cardid);
        return result;
    }
}
