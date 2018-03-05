package com.rw.finance.common.entity;

import javax.persistence.*;

/**
 * @author huanghongfei
 * @file AgentAccount.java
 * @date 2017年12月25日 上午9:57:16
 * @declaration
 */
@Entity
@Table(name = "agent_account")
public class AgentAccount extends BaseEntity {

    private static final long serialVersionUID = -7127155530620860954L;

    // 账户编号
    @Id
    @GeneratedValue
    @Column(nullable = false, name = "account_id")
    private Long accountid;

    // 代理编号
    @Column(nullable = false, name = "agent_id")
    private Long agentid;

    // 用户费率
    @Column(nullable = false, name = "user_rate")
    private Double userrate;

    // 结算费率
    @Column(nullable = false, name = "settle_rate")
    private Double settlerate;

    // 结算周期
    @Column(nullable = false, name = "settle_circle")
    private Integer settlecircle;

    // 分润比例
    @Column(nullable = false, name = "repay_share_rate")
    private Double repaysharerate;

    // 激活分润比例
    @Column(nullable = false, name = "activate_share_rate")
    private Double activatesharerate;

    // 套现收益比例
    @Column(nullable = false, name = "borrow_share_rate")
    private Double borrowsharerate;

    // 代还总额
    @Column(nullable = false, name = "repay_total")
    private Double repaytotal;

    // 代还收益
    @Column(nullable = false, name = "repay_income")
    private Double repayincome;

    // 套现总额
    @Column(nullable = false, name = "cash_total")
    private Double cashtotal;

    // 套现收益
    @Column(nullable = false, name = "cash_income")
    private Double cashincome;

    // 可用余额
    @Column(nullable = false, name = "usable_balance")
    private Double usablebalance;

    // 锁定余额
    @Column(nullable = false, name = "lock_balance")
    private Double lockbalance;

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    public Double getUserrate() {
        return userrate;
    }

    public void setUserrate(Double userrate) {
        this.userrate = userrate;
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
}
