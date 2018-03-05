package com.rw.finance.admin.service;

import com.rw.finance.admin.model.*;
import com.rw.finance.common.entity.AgentInfo;
import com.rw.finance.common.utils.Result;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 代理接口
 *
 * @author huanghongfei
 * @file AgentInfoService.java
 * @date 2017年12月12日 上午10:10:50
 * @declaration
 */
public interface AgentInfoService {
    /**
     * 代理登陆，返回授权码
     *
     * @param username
     * @param password
     * @return jwt
     */
    String login(String username, String password);

    /**
     * 取得代理编号
     *
     * @param username
     * @param mobile
     * @param isagent
     * @return
     */
    Long getAgentId(String username, String mobile, Boolean isagent);

    /**
     * 根据代理编号获取代理信息
     *
     * @param agentid
     * @return
     */
    AgentInfoModel getAgentInfo(Long agentid);

    /**
     * 取得代理明细
     *
     * @param agentid
     * @return
     */
    AgentDetailModel getAgentDetail(Long agentid);

    /**
     * 查询代理信息（含分页）
     *
     * @param model
     * @return
     */
    Page<AgentInfo> getAgentInfos(AgentInfoQueryModel model);

    /**
     * 保存代理信息
     *
     * @param parentid
     * @param info
     */
    Result saveAgentInfo(long parentid, AgentInfoModel info);

    /**
     * 修改登录密码
     *
     * @param agentid
     * @param newpwd
     */
    Result updateLoginPwd(Long agentid, String newpwd);

    /**
     * 修改交易密码
     *
     * @param agentid
     * @param newpwd
     */
    Result updatePayPwd(Long agentid, String newpwd);

    /**
     * 修改代理状态
     *
     * @param agentid
     * @param status
     */
    Result updateStatus(List<Long> agentid, Integer status);

    /**
     * 修改用户费率
     *
     * @param agentid
     * @param rate
     * @return
     */
    Result updateUserRate(Long agentid, Double rate);

    /**
     * 删除代理信息
     *
     * @param agentid
     * @return
     */
    Result deleteAgentInfo(Long agentid);

    /**
     * 取得代理统计
     *
     * @param agentid
     * @param start
     * @param end
     * @return
     */
    CountAgentEChartsModel getAgentCount(Long agentid, String start, String end);
}
