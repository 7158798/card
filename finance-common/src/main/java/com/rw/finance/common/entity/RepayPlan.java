package com.rw.finance.common.entity;


import java.util.Date;

import javax.persistence.*;

import com.rw.finance.common.constants.RepayPlanConstants;
import com.rw.finance.common.utils.DateUtils;

/**
 * 还款计划
 *
 * @author huanghongfei
 * @file RepayPlan.java
 * @date 2017年12月15日 下午1:44:27
 * @declaration
 */
@Entity
@Table(name = "repay_plan")
public class RepayPlan extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -281006464013762595L;

    public RepayPlan(){}
    
    public RepayPlan(long memberId,long cardId,int planType,double poundage,double money,int stageCount,String begDate,String endDate){
    	this.memberid=memberId;
    	this.cardid=cardId;
    	this.plantype=planType;
    	this.poundage=poundage;
    	this.money=money;
    	this.stagecount=stageCount;
    	this.begdate=begDate;
    	this.enddate=endDate;
    	this.status=RepayPlanConstants.Status.STATUS0.getStatus();
    	this.updatetime=DateUtils.getTimeStr(new Date());
    	this.createtime=DateUtils.getTimeStr(new Date());
    }
    
    @Id
    @GeneratedValue
    @Column(name = "plan_id")
    private Long planid;//编号
    @Column(nullable = false, name = "member_id")
    private Long memberid;
    @Transient
    public String membername;
    @Column(nullable = false, name = "card_id")
    private Long cardid;//卡号
    @Column(nullable = false, name = "plan_type")
    private Integer plantype;
    @Column(nullable = false)
    private Double money;//金额
    @Column(nullable = false)
    private Double poundage;//手续费
    @Column(nullable = false)
    private Integer status;//状态
    @Column(nullable = false, name = "stage_count")
    private Integer stagecount;//期数
    @Column(nullable = false, length = 10, name = "beg_date")
    private String begdate;//开始时间
    @Column(nullable = false, length = 10, name = "end_date")
    private String enddate;//结束日期
    @Column(nullable = false, length = 19, name = "update_time")
    private String updatetime;//更新日期
    @Column(nullable = false, length = 19, name = "create_time")
    private String createtime;//结束日期

    public Long getPlanid() {
        return planid;
    }

    public void setPlanid(Long planid) {
        this.planid = planid;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public Long getCardid() {
        return cardid;
    }

    public void setCardid(Long cardid) {
        this.cardid = cardid;
    }

    public Integer getPlantype() {
        return plantype;
    }

    public void setPlantype(Integer plantype) {
        this.plantype = plantype;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getPoundage() {
        return poundage;
    }

    public void setPoundage(Double poundage) {
        this.poundage = poundage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStagecount() {
        return stagecount;
    }

    public void setStagecount(Integer stagecount) {
        this.stagecount = stagecount;
    }

    public String getBegdate() {
        return begdate;
    }

    public void setBegdate(String begdate) {
        this.begdate = begdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
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


}
