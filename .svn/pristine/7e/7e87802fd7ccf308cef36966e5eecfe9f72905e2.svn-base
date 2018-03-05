package com.rw.finance.common.entity;

import javax.persistence.*;

/**
 * 代理信息
 */
@Entity
@Table(name = "agent_info")
public class AgentInfo extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = 5916916338389067308L;

    // 代理编号
    @Id
    @GeneratedValue
    @Column(nullable = false, name = "agent_id")
    private Long agentid;

    // 代理账号
    @Column(nullable = false, unique = true)
    private String username;

    // 登录密码
    @Column(nullable = false)
    private String password;

    // 支付密码
    @Column(nullable = true, name = "pay_pwd")
    private String paypwd;

    // 代理名称
    @Column(name = "agent_name")
    private String agentname;

    // 联系人
    @Column(name = "linkman")
    private String linkman;

    // 联系人电话
    @Column(length = 11)
    private String mobile;

    // 介绍
    @Column(length = 200)
    private String intro;

    // 上级代理编号
    @Column(name = "parent_id")
    private Long parentid;

    /**
     * 代理类型
     */
    @Column(nullable = false, unique = true, name = "type_id")
    private Long typeid;

    /**
     * 代理类型
     */
    @Transient
    public String typename;

    // 代理等级
    @Column(nullable = false, name = "agent_level")
    private Integer agentlevel;

    // 权限等级
    @Column(nullable = false, name = "power_level")
    private Long powerlevel;

    // 状态
    @Column(nullable = false)
    private Integer status;

    // 修改时间
    @Column(nullable = false, length = 19, name = "update_time")
    private String updatetime;

    // 创建时间
    @Column(nullable = false, length = 19, name = "create_time")
    private String createtime;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPaypwd() {
        return paypwd;
    }

    public void setPaypwd(String paypwd) {
        this.paypwd = paypwd;
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

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public Integer getAgentlevel() {
        return agentlevel;
    }

    public void setAgentlevel(Integer agentlevel) {
        this.agentlevel = agentlevel;
    }

    public Long getPowerlevel() {
        return powerlevel;
    }

    public void setPowerlevel(Long powerlevel) {
        this.powerlevel = powerlevel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
