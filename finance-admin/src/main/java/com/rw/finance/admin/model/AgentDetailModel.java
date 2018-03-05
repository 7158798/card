package com.rw.finance.admin.model;

import java.util.List;

public class AgentDetailModel {
    // 代理编号
    private Long agentid;

    // 代理账号
    private String username;

    // 代理名称
    private String agentname;

    // 联系人
    private String linkman;

    // 联系人电话
    private String mobile;

    // 介绍
    private String intro;

    // 上级代理
    private Long parentid;

    // 代理类型
    private Long typeid;

    // 类型名称
    private String typename;

    // 代理等级
    private Integer agentlevel;

    // 状态
    private Integer status;

    // 结算费率
    private Double settlerate;

    // 结算周期
    private Integer settlecircle;

    // 用户费率
    private Double userrate;

    // 代还分润比例
    private Double repaysharerate;

    // 激活分润比例
    private Double activatesharerate;

    // 收款分润比例
    private Double borrowsharerate;

    // 代还总额
    private Double repaytotal;

    // 代还收益
    private Double repayincome;

    // 套现总额
    private Double cashtotal;

    // 套现收益
    private Double cashincome;

    // 可用余额
    private Double usablebalance;

    // 冻结金额
    private Double lockbalance;

    // 修改时间
    private String updatetime;

    // 创建时间
    private String createtime;

    // 上级代理
    private AgentDetailModel parentagent;

    // 卡片集合
    private List<AgentCardModel> agentcards;

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getAgentlevel() {
        return agentlevel;
    }

    public void setAgentlevel(Integer agentlevel) {
        this.agentlevel = agentlevel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getSettlerate() {
        return settlerate;
    }

    public void setSettlerate(Double settlerate) {
        this.settlerate = settlerate;
    }

    public Integer getSettlecircle() {
        return settlecircle;
    }

    public void setSettlecircle(Integer settlecircle) {
        this.settlecircle = settlecircle;
    }

    public Double getUserrate() {
        return userrate;
    }

    public void setUserrate(Double userrate) {
        this.userrate = userrate;
    }

    public Double getRepaysharerate() {
        return repaysharerate;
    }

    public void setRepaysharerate(Double repaysharerate) {
        this.repaysharerate = repaysharerate;
    }

    public Double getActivatesharerate() {
        return activatesharerate;
    }

    public void setActivatesharerate(Double activatesharerate) {
        this.activatesharerate = activatesharerate;
    }

    public Double getBorrowsharerate() {
        return borrowsharerate;
    }

    public void setBorrowsharerate(Double borrowsharerate) {
        this.borrowsharerate = borrowsharerate;
    }

    public Double getRepaytotal() {
        return repaytotal;
    }

    public void setRepaytotal(Double repaytotal) {
        this.repaytotal = repaytotal;
    }

    public Double getRepayincome() {
        return repayincome;
    }

    public void setRepayincome(Double repayincome) {
        this.repayincome = repayincome;
    }

    public Double getCashtotal() {
        return cashtotal;
    }

    public void setCashtotal(Double cashtotal) {
        this.cashtotal = cashtotal;
    }

    public Double getCashincome() {
        return cashincome;
    }

    public void setCashincome(Double cashincome) {
        this.cashincome = cashincome;
    }

    public Double getUsablebalance() {
        return usablebalance;
    }

    public void setUsablebalance(Double usablebalance) {
        this.usablebalance = usablebalance;
    }

    public Double getLockbalance() {
        return lockbalance;
    }

    public void setLockbalance(Double lockbalance) {
        this.lockbalance = lockbalance;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public AgentDetailModel getParentagent() {
        return parentagent;
    }

    public void setParentagent(AgentDetailModel parentagent) {
        this.parentagent = parentagent;
    }

    public List<AgentCardModel> getAgentcards() {
        return agentcards;
    }

    public void setAgentcards(List<AgentCardModel> agentcards) {
        this.agentcards = agentcards;
    }
}
