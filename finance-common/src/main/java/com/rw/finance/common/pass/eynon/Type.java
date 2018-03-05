package com.rw.finance.common.pass.eynon;

public enum Type {
    QUICK_ORDER("快捷-支付申请"),
    QUICK_SMS("快捷-发送短信验证码"),
    QUICK_ENTER("快捷-支付确认"),
    QUICK_REFUND("快捷-单笔退款"),
    QUICK_QUERY_ORDER("快捷-交易查询"),
    QUERY_BALANCE("余额查询"),
    ASYNC_NOTIFY("异步通知");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}