package com.rw.finance.common.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 用户等级关联表
 *
 * @author huanghongfei
 * @file MemberLevel.java
 * @date 2017年12月18日 下午3:28:00
 * @declaration
 */
@Entity
@Table(name = "member_level",uniqueConstraints = {@UniqueConstraint(columnNames={"channel_id","level"})})
public class MemberLevel extends BaseEntity {

    private static final long serialVersionUID = -7040487258647742005L;

    @Id
    @GeneratedValue
    @Column(name = "level_id")@JsonIgnore
    private Long levelid;//
    @Column(nullable=false,name="channel_id")@JsonIgnore
    private Long channelid;//渠道编号
    @Column(nullable = false)@JsonIgnore
    private Integer level;//等级
    @Column(nullable= false,name = "repay_rate")
    private Double repayrate;//还款扣税比例
    @Column(nullable=false,name="repay_poundage")
    private Double repaypoundage;//还款额外手续费
    @Column(nullable=false,name="borrow_rate")
    private Double borrowrate;//套现扣税比例
    @Column(nullable=false,name="borrow_poundage")
    private Double borrowpoundage;//套现手续费
    @Column(nullable=false,name="cash_rate")
    private Double cashrate;//提现扣税比例
    @Column(nullable=false,name="cash_poundage")
    private Double cashpoundage;//提现手续费
    public Long getLevelid() {
        return levelid;
    }

    public void setLevelid(Long levelid) {
        this.levelid = levelid;
    }

	public Long getChannelid() {
		return channelid;
	}

	public void setChannelid(Long channelid) {
		this.channelid = channelid;
	}

	public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

	public Double getRepayrate() {
		return repayrate;
	}

	public void setRepayrate(Double repayrate) {
		this.repayrate = repayrate;
	}

	public Double getBorrowrate() {
		return borrowrate;
	}

	public void setBorrowrate(Double borrowrate) {
		this.borrowrate = borrowrate;
	}

	public Double getCashrate() {
		return cashrate;
	}

	public void setCashrate(Double cashrate) {
		this.cashrate = cashrate;
	}

	public Double getRepaypoundage() {
		return repaypoundage;
	}

	public void setRepaypoundage(Double repaypoundage) {
		this.repaypoundage = repaypoundage;
	}

	public Double getBorrowpoundage() {
		return borrowpoundage;
	}

	public void setBorrowpoundage(Double borrowpoundage) {
		this.borrowpoundage = borrowpoundage;
	}

	public Double getCashpoundage() {
		return cashpoundage;
	}

	public void setCashpoundage(Double cashpoundage) {
		this.cashpoundage = cashpoundage;
	}
	
}

