package com.rw.finance.common.entity;

import javax.persistence.*;

/**
 * 激活码实体
 */
@Entity
@Table(name = "actvcode_info")
public class ActvcodeInfo extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = -1988402792614259828L;

    /**
     * 激活码编号
     */
    @Id
    @GeneratedValue
    @Column(name = "active_id")
    private Long activeid;

    /**
     * 激活代码
     */
    @Column(nullable = false, length = 50, name = "active_code")
    private String activecode;

    /**
     * 适用等级
     */
    @Column(nullable = false, length = 1)
    private Integer level;

    /**
     * 代理编号
     */
    @Column(nullable = false, name = "agent_id")
    private Long agentid;

    /**
     * 代理名称
     */
    @Column(nullable = false, name = "agent_name")
    private String agentname;

    /**
     * 用户编号
     */
    @Column(name = "member_id")
    private Long memberid;

    /**
     * 价格
     */
    @Column(name = "price")
    private Double price;

    /**
     * 使用状态
     */
    @Column(nullable = false, length = 1, name = "use_status")
    private Integer usestatus;

    /**
     * 是否可售
     */
    @Column(nullable = false, length = 1, name = "sale_status")
    private Integer salestatus;

    /**
     * 创建时间
     */
    @Column(nullable = false, length = 19, name = "create_time")
    private String createtime;

    /**
     * 使用时间
     */
    @Column(length = 19, name = "use_time")
    private String usetime;

    public Long getActiveid() {
        return activeid;
    }

    public void setActiveid(Long activeid) {
        this.activeid = activeid;
    }

    public String getActivecode() {
        return activecode;
    }

    public void setActivecode(String activecode) {
        this.activecode = activecode;
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

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUsestatus() {
        return usestatus;
    }

    public void setUsestatus(Integer usestatus) {
        this.usestatus = usestatus;
    }

    public Integer getSalestatus() {
        return salestatus;
    }

    public void setSalestatus(Integer salestatus) {
        this.salestatus = salestatus;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUsetime() {
        return usetime;
    }

    public void setUsetime(String usetime) {
        this.usetime = usetime;
    }
}
