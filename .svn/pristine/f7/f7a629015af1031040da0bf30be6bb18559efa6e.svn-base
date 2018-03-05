package com.rw.finance.common.entity;

import javax.persistence.*;

/**
 * 代理类型
 */
@Entity
@Table(name = "agent_type")
public class AgentType extends BaseEntity {
    /**
     * VersionUID
     */
    private static final long serialVersionUID = -9125602192679971883L;

    /**
     * 类型编号
     */
    @Id
    @GeneratedValue
    @Column(name = "type_id")
    private Long typeid;

    /**
     * 类型名称
     */
    @Column(nullable = false, name = "type_name")
    private String typename;

    /**
     * 入驻费用
     */
    @Column(nullable = false, name = "join_cost")
    private Double joincost;

    /**
     * 代还分润比例
     */
    @Column(nullable = false, name = "repay_share_rate")
    private Double repaysharerate;

    /**
     * 收款分润比例
     */
    @Column(nullable = false, name = "borrow_share_rate")
    private Double borrowsharerate;

    /**
     * 激活分润比例
     */
    @Column(nullable = false, name = "activate_share_rate")
    private Double activatesharerate;

    /**
     * 代理等级
     */
    @Column(nullable = false, name = "agent_level")
    private Integer agentlevel;

    // 修改时间
    @Column(nullable = false, length = 19, name = "update_time")
    private String updatetime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Double getJoincost() {
        return joincost;
    }

    public void setJoincost(Double joincost) {
        this.joincost = joincost;
    }

    public Double getRepaysharerate() {
        return repaysharerate;
    }

    public void setRepaysharerate(Double repaysharerate) {
        this.repaysharerate = repaysharerate;
    }

    public Double getBorrowsharerate() {
        return borrowsharerate;
    }

    public void setBorrowsharerate(Double borrowsharerate) {
        this.borrowsharerate = borrowsharerate;
    }

    public Double getActivatesharerate() {
        return activatesharerate;
    }

    public void setActivatesharerate(Double activatesharerate) {
        this.activatesharerate = activatesharerate;
    }

    public Integer getAgentlevel() {
        return agentlevel;
    }

    public void setAgentlevel(Integer agentlevel) {
        this.agentlevel = agentlevel;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
