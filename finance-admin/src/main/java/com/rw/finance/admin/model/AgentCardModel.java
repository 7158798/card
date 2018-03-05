package com.rw.finance.admin.model;

public class AgentCardModel {
    // 卡片编号
    private Long agentcardid;

    // 银行卡号
    private String cardno;

    // 持卡人名
    private String cardholder;

    // 预留手机
    private String mobile;

    // 银行编号
    private Long bankid;

    // 开户银行
    private String bankname;

    // 开户省份
    private String province;

    // 开户城市
    private String city;

    // 代理编号
    private Long agentid;

    // 修改时间
    private String updatetime;

    // 创建时间
    private String createtime;

    public Long getAgentcardid() {
        return agentcardid;
    }

    public void setAgentcardid(Long agentcardid) {
        this.agentcardid = agentcardid;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getBankid() {
        return bankid;
    }

    public void setBankid(Long bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
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
