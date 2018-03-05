package com.rw.finance.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 系统设置
 *
 * @author huanghongfei
 * @file SystemSettings.java
 * @date 2017年12月22日 下午5:54:30
 * @declaration
 */
@Entity
@Table(name = "system_setting")
public class SystemSetting extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -6182797976591278481L;

    @Id
    @GeneratedValue
    @Column(name = "dict_id")@JsonIgnore
    private Long dictid;
    @Column(nullable = false, unique = true, name = "dict_key")
    private String dictkey;
    @Column(nullable = false, name = "dict_val")
    private String dictval;//值
    @Column(nullable = false)@JsonIgnore
    private String remark;//备注
    @Column(nullable = false, length = 1)@JsonIgnore
    private Integer status;//状态：0-正常 1-停用
    @Column(nullable = false, unique = true)@JsonIgnore
    private Integer sort;//排序
    @Column(nullable=false,length=1,name="is_app")@JsonIgnore
    private Integer isapp;//是否app配置
    @Column(nullable = false,length=19, name = "update_time")@JsonIgnore
    private String updatetime;//更新时间
    @Column(nullable = false,length=19, name = "create_time")@JsonIgnore
    private String createtime;//创建时间

    public Long getDictid() {
        return dictid;
    }

    public void setDictid(Long dictid) {
        this.dictid = dictid;
    }

    public String getDictkey() {
        return dictkey;
    }

    public void setDictkey(String dictkey) {
        this.dictkey = dictkey;
    }

    public String getDictval() {
        return dictval;
    }

    public void setDictval(String dictval) {
        this.dictval = dictval;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
	public Integer getIsapp() {
		return isapp;
	}

	public void setIsapp(Integer isapp) {
		this.isapp = isapp;
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
