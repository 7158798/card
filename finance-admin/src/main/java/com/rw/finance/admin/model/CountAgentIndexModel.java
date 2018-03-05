package com.rw.finance.admin.model;

/**
 * 代理首页统计
 */
public class CountAgentIndexModel {
    /**
     * 会员总数
     */
    private Long membercount;

    /**
     * 代理总数
     */
    private Long agentcount;

    /**
     * 交易总额
     */
    private Double tradeamount;

    /**
     * 收益总额
     */
    private Double profitamount;

    /**
     * 可售激活码
     */
    private Long activecount;

    public Long getMembercount() {
        return membercount;
    }

    public void setMembercount(Long membercount) {
        this.membercount = membercount;
    }

    public Long getAgentcount() {
        return agentcount;
    }

    public void setAgentcount(Long agentcount) {
        this.agentcount = agentcount;
    }

    public Double getTradeamount() {
        return tradeamount;
    }

    public void setTradeamount(Double tradeamount) {
        this.tradeamount = tradeamount;
    }

    public Double getProfitamount() {
        return profitamount;
    }

    public void setProfitamount(Double profitamount) {
        this.profitamount = profitamount;
    }

    public Long getActivecount() {
        return activecount;
    }

    public void setActivecount(Long activecount) {
        this.activecount = activecount;
    }
}
