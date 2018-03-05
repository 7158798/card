package com.rw.finance.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 代理操作日志
 *
 * @author huanghongfei
 * @file ProxyLog.java
 * @date 2017年12月12日 上午9:00:39
 * @declaration
 */
@Entity
@Table(name = "log_info")
public class LogInfo extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 3474312614594373922L;

    public LogInfo() {
    }

    public LogInfo(String role, Long userid, String requesturi, String useragent, String method, String methodargs,
				   String remark, int status, String operateip, String exception, String operatetime) {
        this.role = role;
        this.userid = userid;
        this.requesturi = requesturi;
        this.useragent = useragent;
        this.method = method;
        this.methodargs = methodargs;
        this.remark = remark;
        this.operateip = operateip;
        this.exception = exception;
        this.operatetime = operatetime;
    }

    @Id
    @GeneratedValue
    @Column(name = "log_id")
    private Long logid;
    @Column(nullable = false, length = 1)
    private String role;//A,代理，M用户
    @Column(nullable = false, name = "user_id")
    private Long userid;//用户编号
    @Column(nullable = false, name = "request_uri")
    private String requesturi;//请求地址
    @Column(nullable = false, name = "user_agent",length=1000)
    private String useragent;//
    @Column(nullable = false)
    private String method;//请求方法
    @Column(name = "method_args",length=1000)
    private String methodargs;//参数列表
    @Column()
    private String remark;//备注
    @Column()
    private Integer status;//请求状态
    @Column(nullable = false, name = "operate_ip")
    private String operateip;//操作ip
    @Column()
    private String exception;
    @Column(nullable = false, name = "operate_time")
    private String operatetime;//

    public Long getLogid() {
        return logid;
    }

    public void setLogid(Long logid) {
        this.logid = logid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getRequesturi() {
        return requesturi;
    }

    public void setRequesturi(String requesturi) {
        this.requesturi = requesturi;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }

    public String getMethodargs() {
        return methodargs;
    }

    public void setMethodargs(String methodargs) {
        this.methodargs = methodargs;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOperateip() {
        return operateip;
    }

    public void setOperateip(String operateip) {
        this.operateip = operateip;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(String operatetime) {
        this.operatetime = operatetime;
    }

}
