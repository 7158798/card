package com.rw.finance.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 支付渠道
 * @file PayChannel.java	
 * @author huanghongfei
 * @date 2018年2月1日 下午3:43:38
 * @declaration
 */
@Entity
@Table(name="pay_channel")
public class PayChannel extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2323045365180344108L;

	@Id
	@GeneratedValue
	@Column(name="channel_id")
	private Long channelid;
	@Column(nullable=false,unique=true)@JsonIgnore
	private String channel;//支付渠道标识
	@Column(unique=true)
	private String name;//渠道名称
	@Column(unique=true)
	private String depict;//渠道描述
	@Column(nullable=false,length=1,name="is_enable")@JsonIgnore
	private Integer isenable;//是否启用
	@Column(nullable=false,name="min_amount")
	private Double minamount;//通道起始金额
	@Column(nullable=false,name="max_amount")
	private Double maxamout;//通道最大交易
	@Column(nullable=false,length=1,name="back_mode")
	private Integer backmode;//回调模式
	@Column(nullable=false,length=1,name="is_def")@JsonIgnore
	private Integer isdef;//是否默认
	@Column(nullable=false,name="create_time")@JsonIgnore
	private String createtime;//创建时间
	@Transient
	private Set<MemberLevel> memberLevels=new HashSet<MemberLevel>();
	
	public Long getChannelid() {
		return channelid;
	}
	public void setChannelid(Long channelid) {
		this.channelid = channelid;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepict() {
		return depict;
	}
	public void setDepict(String depict) {
		this.depict = depict;
	}
	public Integer getIsenable() {
		return isenable;
	}
	public void setIsenable(Integer isenable) {
		this.isenable = isenable;
	}
	
	public Double getMinamount() {
		return minamount;
	}
	public void setMinamount(Double minamount) {
		this.minamount = minamount;
	}
	public Double getMaxamout() {
		return maxamout;
	}
	public void setMaxamout(Double maxamout) {
		this.maxamout = maxamout;
	}
	public Integer getBackmode() {
		return backmode;
	}
	public void setBackmode(Integer backmode) {
		this.backmode = backmode;
	}
	public Integer getIsdef() {
		return isdef;
	}
	public void setIsdef(Integer isdef) {
		this.isdef = isdef;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Set<MemberLevel> getMemberLevels() {
		return memberLevels;
	}
	public void setMemberLevels(Set<MemberLevel> memberLevels) {
		this.memberLevels = memberLevels;
	}
}
