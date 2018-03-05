package com.rw.finance.admin.model;

/**
 * 查询还款计划条件
 */
public class RepayPlanQueryModel extends PaggingModel {
    /**
     * 会员编号
     */
    private Long memberid;

    /**
     * 代理编号
     */
    private Long agentid;

    /**
     * 计划类型
     */
    private Integer plantype;

    /**
     * 状态
     */
    private Integer status;

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    public Integer getPlantype() {
        return plantype;
    }

    public void setPlantype(Integer plantype) {
        this.plantype = plantype;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
