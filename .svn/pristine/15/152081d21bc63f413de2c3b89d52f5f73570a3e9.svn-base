package com.rw.finance.common.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.Md5Util;

import javax.persistence.*;

/**
 * @author huanghongfei
 * @file MemberInfo.java
 * @date 2017年12月9日 下午1:32:23
 * @declaration
 */
@Entity
@Table(name = "member_info")
public class MemberInfo extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1562199324457633014L;

    public MemberInfo(){}
    
    public MemberInfo(String realName,String telephone,String password,String payPwd,String registerIp){
    	this.realname=realName;
    	this.telephone=telephone;
    	this.password=Md5Util.md5(password);
    	this.paypwd=payPwd;
    	this.registerip=registerIp;
    	this.level=MemberInfoConstants.Level.LEVEL_0;
    	this.isreal=0;
    	this.idtype=MemberInfoConstants.IdType.IDTYPE1.getIdType();
    	this.status=MemberInfoConstants.Status.STATUS1.getStatus();
    	this.registertime=DateUtils.getTimeStr(new Date());
    	this.lastlogintime=DateUtils.getTimeStr(new Date());
    }
    /**
     * 实名认证参数传入
     */
    public void isReal(String realName,String idNumber,String idPath,String idobverse,String idreverse,String realcardpath){
    	this.realname=realName;
    	this.idnumber=idNumber;
    	this.idpath=idPath;
    	this.idobverse=idobverse;
    	this.idreverse=idreverse;
    	this.isreal=1;
    	this.isrealtime=DateUtils.getTimeStr(new Date());
    	this.realcardpath=realcardpath;
    }
    
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long memberid;
    @Column(name = "nick_name")
    private String nickname;//用户名称
    @Column(nullable = false, name = "real_name")
    private String realname;//真实姓名
    @Column(nullable = false, name = "password")@JsonIgnore
    private String password;//登陆密码
    @Column(nullable = false, length = 6, name = "pay_pwd")@JsonIgnore
    private String paypwd;//支付密码
    @Column(nullable = false,unique=true, length = 11)
    private String telephone;//手机号
    @Column(nullable = false, length = 1, name = "id_type")
    private Integer idtype;//证件类型
    @Column(length = 19,unique = true, name = "id_number")
    private String idnumber;//证件号
    @Column(nullable = false, length = 1,name="is_real")
    private Integer isreal;//是否实名认证
    @Column(name="id_path")@JsonIgnore
    private String idpath;//手持证件
    @Column(name="id_obverse")@JsonIgnore
    private String idobverse;//身份证正面
    @Column(name="id_reverse")@JsonIgnore
    private String idreverse;//身份证背面
    @Column(name="real_card_path")@JsonIgnore
    private String realcardpath;//认证卡片路径
    @Column(name = "head_path")
    private String headpath;//头像路径
    @Column(nullable = false, length = 1)
    private Integer level;//会员等级
    @Column(nullable=true,length=19,name="level_time")
    private String leveltime;//会员使用时间
    @Column(name = "agent_id")
    private Long agentid;//所属代理编号
    @Transient
    public String agentname;//代理名称
    @Column(name = "parent_id")
    private Long parentid;//邀请user的编号
    @Column(nullable = false, length = 1)
    private Integer status;//状态
    @Column(length = 19, name = "active_time")@JsonIgnore
    private String activetime;//激活时间
    @Column(name = "register_ip")
    private String registerip;
    @Column(nullable = false, length = 19, name = "register_time")
    private String registertime;//注册日期
    @Column(length=19,name="is_real_time")@JsonIgnore
    private String isrealtime;//实名认证时间
    @Column(nullable = false, length = 19, name = "last_login_time")
    private String lastlogintime;//最后一次登录时间

    public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPaypwd() {
        return paypwd;
    }

    public void setPaypwd(String paypwd) {
        this.paypwd = paypwd;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getIdtype() {
        return idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public Integer getIsreal() {
        return isreal;
    }

    public void setIsreal(Integer isreal) {
        this.isreal = isreal;
    }

    public String getHeadpath() {
        return headpath;
    }

    public void setHeadpath(String headpath) {
        this.headpath = headpath;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLeveltime() {
        return leveltime;
    }

    public void setLeveltime(String leveltime) {
        this.leveltime = leveltime;
    }

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getActivetime() {
        return activetime;
    }

    public String getRegisterip() {
        return registerip;
    }

    public void setRegisterip(String registerip) {
        this.registerip = registerip;
    }

    public void setActivetime(String activetime) {
        this.activetime = activetime;
    }

    public String getRegistertime() {
        return registertime;
    }

    public void setRegistertime(String registertime) {
        this.registertime = registertime;
    }
    
    public String getIsrealtime() {
		return isrealtime;
	}

	public void setIsrealtime(String isrealtime) {
		this.isrealtime = isrealtime;
	}

	public String getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

	public String getIdpath() {
		return idpath;
	}

	public void setIdpath(String idpath) {
		this.idpath = idpath;
	}

	public String getIdobverse() {
		return idobverse;
	}

	public void setIdobverse(String idobverse) {
		this.idobverse = idobverse;
	}

	public String getIdreverse() {
		return idreverse;
	}

	public void setIdreverse(String idreverse) {
		this.idreverse = idreverse;
	}

	public String getRealcardpath() {
		return realcardpath;
	}

	public void setRealcardpath(String realcardpath) {
		this.realcardpath = realcardpath;
	}
}
