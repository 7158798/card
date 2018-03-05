package com.rw.finance.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rw.finance.common.constants.RepayTaskConstants;
import com.rw.finance.common.utils.DateUtils;

/**
 * @author huanghongfei
 * @file RepayTask.java
 * @date 2017年12月15日 下午2:01:38
 * @declaration
 */
@Entity
@Table(name = "repay_task")
public class RepayTask extends BaseEntity {

    /**
     * 还款任务
     */
    private static final long serialVersionUID = -7266481197000355919L;
    
    public RepayTask(){}
    
    public RepayTask(long planid,int batch,long memberid,double taskAmount,double actualAmount,int taskType,double poundage,int currentStage,String executeTime){
    	this.planid=planid;
    	this.batch=batch;
    	this.memberid=memberid;
    	this.taskamount=taskAmount;
    	this.actualamount=actualAmount;
    	this.tasktype=taskType;
    	this.poundage=poundage;
    	this.currentstage=currentStage;
    	this.executetime=executeTime;
    	this.status=RepayTaskConstants.Status.STATUS0.getStatus();
    	this.createtime=DateUtils.getTimeStr(new Date());
    }

    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private Long taskid;
    @Column(nullable = false, name = "plan_id")
    private Long planid;//计划编号
    @Column()
    private Integer batch;//批次，2次扣款加1次还款为1批
    @Column(nullable = false, name = "member_id")
    private Long memberid;//用户编号
    @Column(nullable = false, name = "task_amount")
    private Double taskamount;//任务金额
    @Column(nullable = false, name = "actual_amount")
    private Double actualamount;//实际金额
    @Column(nullable = false, length = 1, name = "task_type")
    private Integer tasktype;//任务类型
    @Column(nullable = false)
    private Double poundage;//手续费
    @Column(nullable = false, length = 1)
    private Integer status;//状态
    @Column(nullable = false, name = "current_stage")
    private Integer currentstage;//当前期数
    @Column(nullable = false, length = 19, name = "create_time")
    private String createtime;//创建时间
    @Column(nullable = false, length = 19, name = "execute_time")
    private String executetime;//执行时间

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }
	public Integer getBatch() {
		return batch;
	}

	public void setBatch(Integer batch) {
		this.batch = batch;
	}

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

    public Double getTaskamount() {
        return taskamount;
    }

    public void setTaskamount(Double taskamount) {
        this.taskamount = taskamount;
    }

    public Double getActualamount() {
        return actualamount;
    }

    public void setActualamount(Double actualamount) {
        this.actualamount = actualamount;
    }

    public Integer getTasktype() {
        return tasktype;
    }

    public void setTasktype(Integer tasktype) {
        this.tasktype = tasktype;
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

    public Integer getCurrentstage() {
        return currentstage;
    }

    public void setCurrentstage(Integer currentstage) {
        this.currentstage = currentstage;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getExecutetime() {
        return executetime;
    }

    public void setExecutetime(String executetime) {
        this.executetime = executetime;
    }


}
