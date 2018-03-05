package com.rw.finance.admin.model;

/**
 * 会员信息条件Model
 */
public class MemberInfoQueryModel extends PaggingModel {
    /**
     * 手机号码
     */
    private String telephone;

    /**
     * 会员名称
     */
    private String nickname;

    /**
     * 是否实名
     */
    private Integer isreal;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 证件号码
     */
    private String idnumber;

    /**
     * 会员等级
     */
    private Integer level;

    /**
     * 代理编号
     */
    private Long agentid;

    /**
     * 代理等级
     */
    private Long agentlevel;

    /**
     * 代理名称
     */
    private String agentname;

    /**
     * 会员状态
     */
    private Integer status;

    /**
     * 是否遍历子级
     */
    private Boolean loopchild;

    /**
     * 开始时间
     */
    private String sregistertime;

    /**
     * 结束时间
     */
    private String eregistertime;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getIsreal() {
        return isreal;
    }

    public void setIsreal(Integer isreal) {
        this.isreal = isreal;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    public Long getAgentlevel() {
        return agentlevel;
    }

    public void setAgentlevel(Long agentlevel) {
        this.agentlevel = agentlevel;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getLoopchild() {
        return loopchild;
    }

    public void setLoopchild(Boolean loopchild) {
        this.loopchild = loopchild;
    }

    public String getSregistertime() {
        return sregistertime;
    }

    public void setSregistertime(String sregistertime) {
        this.sregistertime = sregistertime;
    }

    public String getEregistertime() {
        return eregistertime;
    }

    public void setEregistertime(String eregistertime) {
        this.eregistertime = eregistertime;
    }
}
