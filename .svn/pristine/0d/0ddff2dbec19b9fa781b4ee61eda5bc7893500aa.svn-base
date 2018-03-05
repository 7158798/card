package com.rw.finance.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 代理卡片
 */
@Entity
@Table(name = "agent_card")
public class AgentCard extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = 7012310775479017170L;

    // 卡片编号
    @Id
    @GeneratedValue
    @Column(nullable = false, name = "agent_card_id")
    private Long agentcardid;

    // 银行卡号
    @Column(nullable = false, length = 50, name = "card_no")
    private String cardno;

    // 持卡人名
    @Column(nullable = false, name = "card_holder")
    private String cardholder;

    // 预留手机
    @Column(nullable = false, length = 11)
    private String mobile;

    // 银行编号
    @Column(nullable = false, name = "bank_id")
    private Long bankid;

    // 开户银行
    @Column(nullable = false, name = "bank_name")
    private String bankname;

    // 开户省份
    @Column()
    private String province;

    // 开户城市
    @Column()
    private String city;

    // 银行缩写
    @Column
    private String abbreviation;

    // 代理编号
    @Column(nullable = false, name = "agent_id")
    private Long agentid;

    // 修改时间
    @Column(length = 19, name = "update_time")
    private String updatetime;

    // 创建时间
    @Column(nullable = false, length = 19, name = "create_time")
    private String createtime;

    // 是否删除
    @Column()
    private Integer isdel;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
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

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
