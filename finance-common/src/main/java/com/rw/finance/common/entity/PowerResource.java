package com.rw.finance.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "power_resource")
public class PowerResource extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = 7348337775872506003L;

    // 资源编号
    @Id
    @GeneratedValue
    @Column(nullable = false, name = "resource_id")
    private Long resourceid;

    // 父级编号
    @Column(nullable = false, name = "parent_id")
    private Long parentid;

    // 资源名称
    @Column(nullable = false, name = "resource_name", length = 50)
    private String resourcename;

    // 资源地址
    @Column(nullable = false, name = "resource_url", length = 255)
    private String resourceurl;

    // 资源图标
    @Column(nullable = true, name = "resource_ico", length = 50)
    private String resourceico;

    // 排序编号
    @Column(nullable = true, name = "sort_no")
    private Long sortno;

    // 类型
    @Column(nullable = false, length = 1)
    private Integer type;

    // 状态
    @Column(nullable = false, length = 1)
    private Integer status;

    // 备注
    @Column(nullable = true, length = 500)
    private String remark;

    public Long getResourceid() {
        return resourceid;
    }

    public void setResourceid(Long resourceid) {
        this.resourceid = resourceid;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public String getResourceurl() {
        return resourceurl;
    }

    public void setResourceurl(String resourceurl) {
        this.resourceurl = resourceurl;
    }

    public String getResourceico() {
        return resourceico;
    }

    public void setResourceico(String resourceico) {
        this.resourceico = resourceico;
    }

    public Long getSortno() {
        return sortno;
    }

    public void setSortno(Long sortno) {
        this.sortno = sortno;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

