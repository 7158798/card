package com.rw.finance.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rw.finance.common.utils.DateUtils;

/**
 * 会员推荐分润
 *
 * @author huanghongfei
 * @file MemberProfit.java
 * @date 2017年12月22日 下午4:31:26
 * @declaration
 */
@Entity
@Table(name = "member_profit")
public class MemberProfit extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -3776087591682681165L;

    public MemberProfit() {
    }

    public MemberProfit(long memberid, long promemberid, String protelephone, int biztype, Double bizamount,
						Double amount, String tradeno, int level) {
        this.memberid = memberid;
        this.promemberid = promemberid;
        this.protelephone = protelephone;
        this.biztype = biztype;
        this.bizamount = bizamount;
        this.amount = amount;
        this.tradeno = tradeno;
        this.level = level;
        this.createtime = DateUtils.getTimeStr(new Date());
    }

    @Id
    @GeneratedValue
    @Column(name = "pofit_id")
    private Long pofitid;
    @Column(nullable = false, name = "member_id")
    private Long memberid;//会员编号
    @Column(nullable = false, name = "pro_member_id")
    private Long promemberid;//生产该利润的会员编号
    @Column(nullable = false, name = "pro_telephone")
    private String protelephone;//贡献账户
    @Column(nullable = false, name = "biz_type")
    private Integer biztype;//利润类型说明
    @Column(nullable = false, name = "biz_amount")
    private Double bizamount;//交易金额
    @Column(nullable = false)
    private Double amount;//利润金额
    @Column(nullable = false, name = "trade_no")
    private String tradeno;//流水号
    @Column(nullable = false)
    private Integer level;//收益等级
    @Column(nullable = false, name = "create_time")
    private String createtime;//创建时间

    public Long getPofitid() {
        return pofitid;
    }

    public void setPofitid(Long pofitid) {
        this.pofitid = pofitid;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public Long getPromemberid() {
        return promemberid;
    }

    public void setPromemberid(Long promemberid) {
        this.promemberid = promemberid;
    }

    public String getProtelephone() {
        return protelephone;
    }

    public void setProtelephone(String protelephone) {
        this.protelephone = protelephone;
    }
    
    public Integer getBiztype() {
		return biztype;
	}

	public void setBiztype(Integer biztype) {
		this.biztype = biztype;
	}

	public Double getBizamount() {
        return bizamount;
    }

    public void setBizamount(Double bizamount) {
        this.bizamount = bizamount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }


}
