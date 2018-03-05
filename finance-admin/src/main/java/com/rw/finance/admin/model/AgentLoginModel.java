package com.rw.finance.admin.model;

import java.util.List;

public class AgentLoginModel {
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

    // 上级代理
    private Long parentid;

    // 代理类型
    private Long typeid;

    // 代理等级
    private Integer agentlevel;

    // 权限等级
    private Long powerlevel;

    // 菜单集合
    private List<PowerResourceModel> menues;

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

    public List<PowerResourceModel> getMenues() {
        return menues;
    }

    public void setMenues(List<PowerResourceModel> menues) {
        this.menues = menues;
    }
}
