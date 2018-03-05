package com.rw.finance.admin.model;

import java.util.List;

/**
 * 交易曲线图统计
 */
public class CountOrderEChartsModel {
    /**
     * 日期集合
     */
    private List<String> date;

    /**
     * 交易合计
     */
    private List<Double> total;

    /**
     * 代还
     */
    private List<Double> type0;

    /**
     * 提现
     */
    private List<Double> type1;

    /**
     * 收款
     */
    private List<Double> type2;

    /**
     * 激活
     */
    private List<Double> type3;

    /**
     * 代理提现
     */
    private List<Double> type4;

    /**
     * 贷记卡鉴权
     */
    private List<Double> type5;

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public List<Double> getTotal() {
        return total;
    }

    public void setTotal(List<Double> total) {
        this.total = total;
    }

    public List<Double> getType0() {
        return type0;
    }

    public void setType0(List<Double> type0) {
        this.type0 = type0;
    }

    public List<Double> getType1() {
        return type1;
    }

    public void setType1(List<Double> type1) {
        this.type1 = type1;
    }

    public List<Double> getType2() {
        return type2;
    }

    public void setType2(List<Double> type2) {
        this.type2 = type2;
    }

    public List<Double> getType3() {
        return type3;
    }

    public void setType3(List<Double> type3) {
        this.type3 = type3;
    }

    public List<Double> getType4() {
        return type4;
    }

    public void setType4(List<Double> type4) {
        this.type4 = type4;
    }

    public List<Double> getType5() {
        return type5;
    }

    public void setType5(List<Double> type5) {
        this.type5 = type5;
    }
}
