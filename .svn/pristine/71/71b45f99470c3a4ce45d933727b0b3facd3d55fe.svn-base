package com.rw.finance.common.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rw.finance.common.constants.MemberCardConstatns;
import com.rw.finance.common.utils.BankUtils;
import com.rw.finance.common.utils.DateUtils;

/**
 * 银行卡
 *
 * @author huanghongfei
 * @file MemberCard.java
 * @date 2017年12月13日 上午9:31:05
 * @declaration
 */
@Entity
@Table(name = "member_card")
public class MemberCard extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 4227415276100186270L;

    public MemberCard(){}
    /**
     * 借记卡
     * @param memberid
     * @param bankid
     * @param realname
     * @param cardno
     * @param bankcode
     * @param bankname
     * @param banklogo
     * @param cardcolor
     */
    public MemberCard(long memberid,String idnumber,long bankid,String realname,
					  String cardno,String mobile,String bankcode,String bankname,
					  String abbreviation,String banklogo,String cardcolor,String bankextra){
    	this.memberid=memberid;
    	this.idnumber=idnumber;
    	this.bankid=bankid;
    	this.realname=realname;
    	this.cardno=cardno;
    	this.mobile=mobile;
    	this.authcode="000";
    	this.bankcode=bankcode;
    	this.bankname=bankname;
    	this.banklogo=banklogo;
    	this.cardcolor=cardcolor;
    	this.type=MemberCardConstatns.Type.TYPE1.getType();
    	this.status=MemberCardConstatns.Status.STATUS0.getStatus();
    	this.updatetime=DateUtils.getTimeStr(new Date());
    	this.createtime=DateUtils.getTimeStr(new Date());
    	this.isdel=0;
    	com.rw.finance.common.utils.BankUtils.BankInfo bankInfo=BankUtils.getBankInfo(cardno);
    	if(bankInfo.getError_code()==0){
    		this.province=bankInfo.getResult().getProvince();
        	this.city=bankInfo.getResult().getCity();
    	}
    	this.abbreviation=abbreviation;
    	this.bankextra=bankextra;
    }
    
    /**
     * 贷记卡
     * @param memberid
     * @param idnumber
     * @param bankid
     * @param cardno
     * @param realname
     * @param expirydate
     * @param authcode
     * @param billdate
     * @param repaydate
     * @param mobile
     * @param bankcode
     * @param bankname
     * @param banklogo
     * @param bankcolor
     */
    public MemberCard(long memberid,String idnumber,long bankid,String cardno,
    		String realname,String expirydate,String authcode,String billdate,
    		String repaydate,String mobile,String bankcode,String bankname,String abbreviation,
    		String banklogo,String cardcolor,String bankextra){
    	this.memberid=memberid;
    	this.idnumber=idnumber;
    	this.bankid=bankid;
    	this.cardno=cardno;
    	this.realname=realname;
    	this.expirydate=expirydate;
    	this.authcode=authcode;
    	this.billdate=billdate;
    	this.repaydate=repaydate;
    	this.mobile=mobile;
    	this.bankcode=bankcode;
    	this.bankname=bankname;
    	this.banklogo=banklogo;
    	this.cardcolor=cardcolor;
    	this.type=MemberCardConstatns.Type.TYPE2.getType();
    	this.status=MemberCardConstatns.Status.STATUS0.getStatus();
    	this.updatetime=DateUtils.getTimeStr(new Date());
    	this.createtime=DateUtils.getTimeStr(new Date());
    	this.isdel=0;
    	this.isdef=0;
    	com.rw.finance.common.utils.BankUtils.BankInfo bankInfo=BankUtils.getBankInfo(cardno);
    	if(bankInfo.getError_code()==0){
    		this.province=bankInfo.getResult().getProvince();
        	this.city=bankInfo.getResult().getCity();
    	}
    	this.abbreviation=abbreviation;
		this.bankextra=bankextra;
    }
    @Id
    @GeneratedValue
    @Column(name="card_id")
    private Long cardid;
    @Column(nullable = false,unique=true,length = 19,name = "card_no")
    private String cardno;//账号
    @Column(nullable = false, name = "member_id")@JsonIgnore
    private Long memberid;//用户编号
    @Column(nullable=false,length=20,name="id_number")@JsonIgnore
    private String idnumber;//身份证号
    @Column(nullable = false, name = "bank_id")
    private Long bankid;//银行渠道支持编号
    @Column(nullable = false, name = "bank_code")@JsonIgnore
    private String bankcode;
    @Column(nullable = false, name = "bank_name")
    private String bankname;//银行名称
    @Column(name = "bank_logo")
    private String banklogo;//银行标志
    @Column(nullable = false, name = "card_color", length = 50)
    private String cardcolor;//银行卡颜色
    @Column(name="card_path")@JsonIgnore
    private String cardpath;//银行卡照片
    @Column()@JsonIgnore
    private String province;//开户省
    @Column()@JsonIgnore
    private String city;//开户市
    @Column(nullable=false)@JsonIgnore
    private String abbreviation;//银行缩写
	@Column(name="bank_extra")
	private String bankextra;//银行拓展字段json
    @Column(nullable = false,length=1)
    private Integer type;//卡片类型
    @Column(nullable =false,length=11)@JsonIgnore
    private String mobile;//预留电话
    @Column(length = 10, name = "expiry_date")@JsonIgnore
    private String expirydate;//有效期
    @Column(name = "auth_code",length=3)@JsonIgnore
    private String authcode;//鉴权代码
    @Column(nullable=false,length=1)@JsonIgnore
    private Integer status;//状态
    @Column(length =2, name = "bill_date")@Min(value=1)@Max(value=31)
    private String billdate;//账单日期
    @Column(length =2, name = "repay_date")@Min(value=1)@Max(value=31)
    private String repaydate;//还款日期
    @Column(nullable=false,name = "real_name")
    private String realname;//拥有者名称
    @Column(nullable=false,length = 1, name = "is_def")
    private Integer isdef;//是否默认账户
    @Column(nullable = false, length = 19, name = "update_time")@JsonIgnore
    private String updatetime;//修改时间
    @Column(nullable = false, length = 19, name = "create_time")@JsonIgnore
    private String createtime;//时间
    @Column(nullable=false,name="is_del",length=1)@JsonIgnore
    private Integer isdel;//逻辑删除标记
    /**
     * 今天至账单日天数
     */
    @Transient
    private int toBillDate;
    /**
     * 今天至还款日天数
     */
    @Transient
    private int toRepayDate;
    
	public Long getCardid() {
		return cardid;
	}
	public void setCardid(Long cardid) {
		this.cardid = cardid;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public Long getBankid() {
		return bankid;
	}
	public void setBankid(Long bankid) {
		this.bankid = bankid;
	}
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBanklogo() {
		return banklogo;
	}
	public void setBanklogo(String banklogo) {
		this.banklogo = banklogo;
	}
	public String getCardcolor() {
		return cardcolor;
	}
	public void setCardcolor(String cardcolor) {
		this.cardcolor = cardcolor;
	}
	public String getCardpath() {
		return cardpath;
	}
	public void setCardpath(String cardpath) {
		this.cardpath = cardpath;
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

	public String getBankextra() {
		return bankextra;
	}

	public void setBankextra(String bankextra) {
		this.bankextra = bankextra;
	}

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	public String getAuthcode() {
		return authcode;
	}
	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getBilldate() {
		return billdate;
	}
	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}
	public String getRepaydate() {
		return repaydate;
	}
	public void setRepaydate(String repaydate) {
		this.repaydate = repaydate;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getIsdef() {
		return isdef;
	}
	public void setIsdef(Integer isdef) {
		this.isdef = isdef;
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
	public int getToBillDate() {
		return toBillDate;
	}
	public void setToBillDate(int toBillDate) {
		this.toBillDate = toBillDate;
	}
	public int getToRepayDate() {
		return toRepayDate;
	}
	public void setToRepayDate(int toRepayDate) {
		this.toRepayDate = toRepayDate;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public Integer getIsdel() {
		return isdel;
	}
	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

   
}
