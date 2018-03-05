package com.rw.finance.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "power_resource_level")
public class PowerResourceLevel extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = 6309694474918933174L;

    // 编号
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    // 资源编号
    @Column(nullable = false, name = "resources_id")
    private Long resourcesid;

    // 等级编号
    @Column(nullable = false, name = "level_id")
    private Long levelid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResourcesid() {
        return resourcesid;
    }

    public void setResourcesid(Long resourcesid) {
        this.resourcesid = resourcesid;
    }

    public Long getLevelid() {
        return levelid;
    }

    public void setLevelid(Long levelid) {
        this.levelid = levelid;
    }
}
