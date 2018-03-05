package com.rw.finance.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rw.finance.common.constants.LoginInfoConstants;
import com.rw.finance.common.utils.DateUtils;

/**
 * 登录日志
 *
 * @author huanghongfei
 * @file LoginInfo.java
 * @date 2017年12月23日 下午6:14:14
 * @declaration
 */
@Entity
@Table(name = "login_info")
public class LoginInfo extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1037179022688446207L;

    public LoginInfo() {
    }

    public LoginInfo(String accountname, int accounttype, String ip) {
        this.accountname = accountname;
        this.accounttype = accounttype;
        this.ip = ip;
        this.status = 0;
        this.logintime = DateUtils.getTimeStr(new Date());
    }

    @Id
    @GeneratedValue
    @Column(name = "login_id")
    private Long loginid;
    @Column(name = "account_name", nullable = false)
    private String accountname;//账户名
    @Column(nullable = false, length = 1, name = "account_type")
    private Integer accounttype;//账户类型
    @Column(nullable = false)
    private String ip;//ip地址
    @Column(nullable = false, length = 19, name = "login_time")
    private String logintime;//登录时间
    @Column(nullable = false, length = 1)
    private Integer status;//登录状态

    public Long getLoginid() {
        return loginid;
    }

    public void setLoginid(Long loginid) {
        this.loginid = loginid;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
