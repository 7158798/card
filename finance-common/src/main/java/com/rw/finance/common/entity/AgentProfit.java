package com.rw.finance.common.entity;

import java.util.Date;

import javax.persistence.*;

import com.rw.finance.common.utils.DateUtils;

/**
 * 代理收益
 */
@Entity
@Table(name = "agent_profit")
public class AgentProfit extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4900283152747078709L;
	
	public AgentProfit(){}
	
	public AgentProfit(long agentid,long promemberid,long orderid,String tradeno,double rate,double tradeamount,double amount,int profittype){
		this.agentid=agentid;
		this.promemberid=promemberid;
		this.orderid=orderid;
		this.tradeno=tradeno;
		this.rate=rate;
		this.tradeamount=tradeamount;
		this.amount=amount;
		this.profittype=profittype;
		this.createtime=DateUtils.getTimeStr(new Date());
	}

	/**
     * 收益编号
     */
    @Id
    @GeneratedValue
    @Column(nullable = false, name = "profit_id")
    private Long profitid;

    /**
     * 代理编号
     */
    @Column(nullable = false, name = "agent_id")
    private Long agentid;

    /**
     * 贡献会员
     */
    @Column(nullable = false, name = "pro_member_id")
    private Long promemberid;

    /**
     * 订单编号
     */
    @Column(nullable = false, name = "order_id")
    private Long orderid;

    /**
     * 订单流水
     */
    @Column(nullable = false, name = "trade_no")
    private String tradeno;

    /**
     * 计算利率
     */
    @Column(nullable = false, name = "rate")
    private Double rate;

    /**
     * 交易金额
     */
    @Column(nullable = false, name = "trade_amount")
    private Double tradeamount;

    /**
     * 收益金额
     */
    @Column(nullable = false, name = "amount")
    private Double amount;

    /**
     * 收益类型
     */
    @Column(nullable = false, name = "profit_type")
    private Integer profittype;

    /**
     * 添加时间
     */
    @Column(nullable = false, name = "create_time")
    private String createtime;

    public Long getProfitid() {
        return profitid;
    }

    public void setProfitid(Long profitid) {
        this.profitid = profitid;
    }

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    public Long getPromemberid() {
        return promemberid;
    }

    public void setPromemberid(Long promemberid) {
        this.promemberid = promemberid;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }

    public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

    public Double getTradeamount() {
		return tradeamount;
	}

	public void setTradeamount(Double tradeamount) {
		this.tradeamount = tradeamount;
	}

    public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getProfittype() {
        return profittype;
    }

    public void setProfittype(Integer profittype) {
        this.profittype = profittype;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
