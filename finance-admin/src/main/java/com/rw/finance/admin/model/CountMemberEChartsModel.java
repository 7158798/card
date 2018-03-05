package com.rw.finance.admin.model;

import java.util.List;

/**
 * 会员曲线图统计
 */
public class CountMemberEChartsModel {
    /**
     * 日期集合
     */
    private List<String> date;

    /**
     * 新增个数
     */
    private List<Long> registercount;

    /**
     * 激活个数
     */
    private List<Long> activecount;

    /**
     * 登录个数
     */
    private List<Long> logincount;

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public List<Long> getRegistercount() {
        return registercount;
    }

    public void setRegistercount(List<Long> registercount) {
        this.registercount = registercount;
    }

    public List<Long> getActivecount() {
        return activecount;
    }

    public void setActivecount(List<Long> activecount) {
        this.activecount = activecount;
    }

    public List<Long> getLogincount() {
        return logincount;
    }

    public void setLogincount(List<Long> logincount) {
        this.logincount = logincount;
    }
}
