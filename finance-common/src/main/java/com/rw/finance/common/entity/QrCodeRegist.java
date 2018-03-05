package com.rw.finance.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rw.finance.common.utils.DateUtils;
/**
 * 
 * @file QrCodeRegist.java	
 * @author huanghongfei
 * @date 2017年12月28日 下午7:38:01
 * @declaration
 */
@Entity
@Table(name="qrcode_regist")
public class QrCodeRegist extends BaseEntity{

	/**
	 * 二维码注册，用于记录扫二维码的用户唯一特征(IP地址等...)，及是哪一个代理的代理编号
	 */
	private static final long serialVersionUID = 5614508187786261306L;

	public QrCodeRegist(){}
	
	public QrCodeRegist(long memberid,long agentid,String ipaddr,String useragent){
		this.memberid=memberid;
		this.agentid=agentid;
		this.ipaddr=ipaddr;
		this.useragent=useragent;
		this.createtime=DateUtils.getTimeStr(new Date());
	}
	
	@Id
	@GeneratedValue
	@Column(name="regist_id")
	private Long registid;
	@Column(nullable=false,name="member_id")
	private Long memberid;//会员编号
	@Column(nullable=false,name="agent_id")
	private Long agentid;//代理编号
	@Column(nullable=false,name="ip_addr")
	private String ipaddr;//扫二维码的会员IP
	@Column(nullable=false,name="user_agent")
	private String useragent;//用户浏览器系统信息
	@Column(nullable=false,length=19)
	private String createtime;//创建时间
	
	public Long getRegistid() {
		return registid;
	}
	public void setRegistid(Long registid) {
		this.registid = registid;
	}
	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public Long getAgentid() {
		return agentid;
	}

	public void setAgentid(Long agentid) {
		this.agentid = agentid;
	}

	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public String getUseragent() {
		return useragent;
	}
	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	
}
