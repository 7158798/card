package com.rw.finance.common.entity;

import com.rw.finance.common.utils.DateUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * 订单统计，收益统计
 *
 * @author huanghongfei
 * @file OrderCount.java
 * @date 2018年2月2日 上午10:52:46
 * @declaration
 */
@Entity
@Table(name = "order_count")
public class OrderCount extends BaseEntity {

    private static final long serialVersionUID = -5661921650261269731L;

    public OrderCount() {
    }

    public OrderCount(String tradeNo, String tradeType, double tradeAmount, double memberProfitTotal, double
            agentProfitTotal, double companyProfitTotal) {
        this.tradeno = tradeNo;
        this.tradetype = tradeType;
        this.tradeamount = tradeAmount;
        this.memberprofittotal = memberProfitTotal;
        this.agentprofittotal = agentProfitTotal;
        this.companyprofittotal = companyProfitTotal;
        this.createtime = DateUtils.getTimeStr(new Date());
    }

    @Id
    @GeneratedValue
    private Long countid;
    @Column(nullable = false, unique = true)
    private String tradeno;//订单编号
    @Column(nullable = false)
    private String tradetype;//交易类型
    @Column(nullable = false)
    private Double tradeamount;//交易金额
    @Column(nullable = false)
    private Double memberprofittotal;//会员总收益
    @Column(nullable = false)
    private Double agentprofittotal;//代理总收益
    @Column(nullable = false)
    private Double companyprofittotal;//公司收益
    @Column(nullable = false, length = 19)
    private String createtime;//创建时间

    public Long getCountid() {
        return countid;
    }

    public void setCountid(Long countid) {
        this.countid = countid;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }

    public String getTradetype() {
        return tradetype;
    }

    public void setTradetype(String tradetype) {
        this.tradetype = tradetype;
    }

    public Double getTradeamount() {
        return tradeamount;
    }

    public void setTradeamount(Double tradeamount) {
        this.tradeamount = tradeamount;
    }

    public Double getMemberprofittotal() {
        return memberprofittotal;
    }

    public void setMemberprofittotal(Double memberprofittotal) {
        this.memberprofittotal = memberprofittotal;
    }

    public Double getAgentprofittotal() {
        return agentprofittotal;
    }

    public void setAgentprofittotal(Double agentprofittotal) {
        this.agentprofittotal = agentprofittotal;
    }

    public Double getCompanyprofittotal() {
        return companyprofittotal;
    }

    public void setCompanyprofittotal(Double companyprofittotal) {
        this.companyprofittotal = companyprofittotal;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

}
