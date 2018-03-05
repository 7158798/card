package com.rw.finance.admin.model;

/**
 * 统计模型
 */
public class OrderInfoCountModel {
    /**
     * 统计日期
     */
    private String date;

    /**
     * 交易类型
     */
    private Integer type;

    /**
     * 统计金额
     */
    private Double amount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
