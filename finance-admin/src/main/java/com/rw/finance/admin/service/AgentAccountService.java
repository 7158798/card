package com.rw.finance.admin.service;

import com.rw.finance.common.utils.Result;

/**
 * 代理账户接口
 *
 * @author huanghongfei
 * @file AgentAccountService.java
 * @date 2017年12月25日 上午10:02:41
 * @declaration
 */
public interface AgentAccountService {
    /**
     * 申请提现
     *
     * @param agentid
     * @param amount
     * @param cardid
     * @return
     */
    Result applyCash(Long agentid, Double amount, Long cardid);
}
