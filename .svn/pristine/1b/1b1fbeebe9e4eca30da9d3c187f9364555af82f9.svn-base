package com.rw.finance.common.entity.order;

/**
 * 套现记录
 *
 * @author huanghongfei
 * @file BorrowOrder.java
 * @date 2017年12月23日 下午3:48:05
 * @declaration
 */
public class MemberBorrowOrder{

    /**
     * 从信用卡到储蓄卡
     */
    public MemberBorrowOrder(long fromCardId,long toCardId,double poundage) {
    	this.fromCardId=fromCardId;
    	this.toCardId=toCardId;
    	this.poundage=poundage;
    	this.fromSucc=0;
    	this.toSucc=0;
    }

    private long fromCardId;//信用卡编号
    private long toCardId;//储蓄卡编号
    private double poundage;//手续费
    private int fromSucc;//扣款成功
    private int toSucc;//付款成功

	public long getFromCardId() {
		return fromCardId;
	}
	public void setFromCardId(long fromCardId) {
		this.fromCardId = fromCardId;
	}
	public long getToCardId() {
		return toCardId;
	}
	public void setToCardId(long toCardId) {
		this.toCardId = toCardId;
	}
	public double getPoundage() {
		return poundage;
	}
	public void setPoundage(double poundage) {
		this.poundage = poundage;
	}
	public int getFromSucc() {
		return fromSucc;
	}
	public void setFromSucc(int fromSucc) {
		this.fromSucc = fromSucc;
	}
	public int getToSucc() {
		return toSucc;
	}
	public void setToSucc(int toSucc) {
		this.toSucc = toSucc;
	}
}
