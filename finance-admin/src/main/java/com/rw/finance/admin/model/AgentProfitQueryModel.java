package com.rw.finance.admin.model;

/**
 * 查询代理收益条件
 */
public class AgentProfitQueryModel extends PaggingModel {
    /**
     * 代理编号
     */
    private Long agentid;

    /**
     * 交易流水
     */
    private String tradeno;

    /**
     * 收益类型
     */
    private int type;

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
