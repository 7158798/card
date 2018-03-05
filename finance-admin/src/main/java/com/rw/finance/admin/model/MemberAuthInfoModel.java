package com.rw.finance.admin.model;

/**
 * 会员认证信息
 */
public class MemberAuthInfoModel {
    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 手机号码
     */
    private String telephone;

    /**
     * 证件类型
     */
    private Integer idtype;

    /**
     * 证件号码
     */
    private String idnumber;

    /**
     * 手持证件
     */
    private String idpath;

    /**
     * 身份证正面
     */
    private String idobverse;

    /**
     * 身份证背面
     */
    private String idreverse;

    /**
     * 会员头像
     */
    private String headpath;

    /**
     * 是否实名认证
     */
    private Integer isreal;

    /**
     * 实名认证时间
     */
    private String isrealtime;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getIdtype() {
        return idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getIdpath() {
        return idpath;
    }

    public void setIdpath(String idpath) {
        this.idpath = idpath;
    }

    public String getIdobverse() {
        return idobverse;
    }

    public void setIdobverse(String idobverse) {
        this.idobverse = idobverse;
    }

    public String getIdreverse() {
        return idreverse;
    }

    public void setIdreverse(String idreverse) {
        this.idreverse = idreverse;
    }

    public String getHeadpath() {
        return headpath;
    }

    public void setHeadpath(String headpath) {
        this.headpath = headpath;
    }

    public Integer getIsreal() {
        return isreal;
    }

    public void setIsreal(Integer isreal) {
        this.isreal = isreal;
    }

    public String getIsrealtime() {
        return isrealtime;
    }

    public void setIsrealtime(String isrealtime) {
        this.isrealtime = isrealtime;
    }
}
