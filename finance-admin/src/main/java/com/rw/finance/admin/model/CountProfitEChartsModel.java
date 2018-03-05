package com.rw.finance.admin.model;

import java.util.List;

/**
 * 收益曲线图统计
 */
public class CountProfitEChartsModel {
    /**
     * 日期集合
     */
    private List<String> date;

    /**
     * 交易合计
     */
    private List<Double> total;

    /**
     * 会员收益
     */
    private List<Double> memberprofit;

    /**
     * 代理收益
     */
    private List<Double> agentprofit;

    /**
     * 平台收益
     */
    private List<Double> companyprofit;

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public List<Double> getTotal() {
        return total;
    }

    public void setTotal(List<Double> total) {
        this.total = total;
    }

    public List<Double> getMemberprofit() {
        return memberprofit;
    }

    public void setMemberprofit(List<Double> memberprofit) {
        this.memberprofit = memberprofit;
    }

    public List<Double> getAgentprofit() {
        return agentprofit;
    }

    public void setAgentprofit(List<Double> agentprofit) {
        this.agentprofit = agentprofit;
    }

    public List<Double> getCompanyprofit() {
        return companyprofit;
    }

    public void setCompanyprofit(List<Double> companyprofit) {
        this.companyprofit = companyprofit;
    }
}
