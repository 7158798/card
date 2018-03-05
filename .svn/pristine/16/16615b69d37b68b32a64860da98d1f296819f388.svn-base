package com.rw.finance.common.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author huanghongfei
 * @file MemberAccount.java
 * @date 2017年12月13日 下午3:32:17
 * @declaration
 */
@Entity
@Table(name = "member_account")
public class MemberAccount extends BaseEntity {

    /**
     * 用户账户信息
     */
    private static final long serialVersionUID = 9161167800571195049L;

    public MemberAccount() {
    }

    public MemberAccount(long memberid, double repayrate, double repaytotal, double cashtotal, double
            userablebalance, double lockbalance) {
        this.memberid = memberid;
        this.repayrate = repayrate;
        this.repaytotal = repaytotal;
        this.cashtotal = cashtotal;
        this.usablebalance = userablebalance;
        this.lockbalance = lockbalance;
    }

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long accountid;
    @Column(nullable = false, unique = true, name = "member_id")
    private Long memberid;//用户编号
    @Column(nullable = false, name = "repay_rate")
    private Double repayrate;//代还费率
    @Column(nullable = false, name = "repay_total")
    private Double repaytotal;//代还总额
    @Column(nullable = false, name = "cash_total")
    private Double cashtotal;//收款总额
    @Column(nullable = false, name = "usable_balance")
    private Double usablebalance;//可用余额
    @Column(nullable = false, name = "lock_balance")
    private Double lockbalance;//锁定余额

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public Double getRepayrate() {
        return repayrate;
    }

    public void setRepayrate(Double repayrate) {
        this.repayrate = repayrate;
    }

    public Double getRepaytotal() {
        return repaytotal;
    }

    public void setRepaytotal(Double repaytotal) {
        this.repaytotal = repaytotal;
    }

    public Double getCashtotal() {
        return cashtotal;
    }

    public void setCashtotal(Double cashtotal) {
        this.cashtotal = cashtotal;
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
