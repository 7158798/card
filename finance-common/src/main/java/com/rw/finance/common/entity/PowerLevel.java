package com.rw.finance.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "power_level")
public class PowerLevel extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8730072974909245972L;

	// 等级编号
    @Id
    @GeneratedValue
    @Column(nullable = false, name = "level_id")
    private Long levelid;

    // 等级名称
    @Column(nullable = false, name = "level_name", length = 50)
    private String levelname;

    // 激活限量
    @Column(nullable = true, name = "active_limit")
    private Integer activelimit;

    // 结算比例
    @Column(nullable = true, name = "settle_ratio")
    private Integer settleratio;

    // 运用对象
    @Column(nullable = false, name = "level_object")
    private Integer levelobject;

    // 数据权限
    @Column(nullable = false, name = "data_power")
    private Integer datapower;

    public Long getLevelid() {
        return levelid;
    }

    public void setLevelid(Long levelid) {
        this.levelid = levelid;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public Integer getActivelimit() {
        return activelimit;
    }

    public void setActivelimit(Integer activelimit) {
        this.activelimit = activelimit;
    }

    public Integer getSettleratio() {
        return settleratio;
    }

    public void setSettleratio(Integer settleratio) {
        this.settleratio = settleratio;
    }

    public Integer getLevelobject() {
        return levelobject;
    }

    public void setLevelobject(Integer levelobject) {
        this.levelobject = levelobject;
    }

    public Integer getDatapower() {
        return datapower;
    }

    public void setDatapower(Integer datapower) {
        this.datapower = datapower;
    }
}
