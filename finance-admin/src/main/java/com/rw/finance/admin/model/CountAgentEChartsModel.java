package com.rw.finance.admin.model;

import java.util.List;

/**
 * 代理曲线图统计
 */
public class CountAgentEChartsModel {
    /**
     * 日期集合
     */
    private List<String> date;

    /**
     * 新增代理
     */
    private List<Long> addcount;

    /**
     * 一级代理
     */
    private List<Long> level1count;

    /**
     * 二级代理
     */
    private List<Long> level2count;

    /**
     * 三级代理
     */
    private List<Long> level3count;

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public List<Long> getAddcount() {
        return addcount;
    }

    public void setAddcount(List<Long> addcount) {
        this.addcount = addcount;
    }

    public List<Long> getLevel1count() {
        return level1count;
    }

    public void setLevel1count(List<Long> level1count) {
        this.level1count = level1count;
    }

    public List<Long> getLevel2count() {
        return level2count;
    }

    public void setLevel2count(List<Long> level2count) {
        this.level2count = level2count;
    }

    public List<Long> getLevel3count() {
        return level3count;
    }

    public void setLevel3count(List<Long> level3count) {
        this.level3count = level3count;
    }
}
