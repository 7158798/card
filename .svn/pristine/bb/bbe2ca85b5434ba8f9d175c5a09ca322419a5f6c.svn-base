package com.rw.finance.common.entity;

import com.rw.finance.common.constants.OrderInfoConstants;
import com.rw.finance.common.utils.DateUtils;

import javax.persistence.*;

import java.util.Date;

/**
 * 订单表
 *
 * @author huanghongfei
 * @file OrderInfo.java
 * @date 2017年12月15日 上午9:33:32
 * @declaration
 */
@Entity
@Table(name = "order_info")
public class OrderInfo extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 386320189211469475L;

    public OrderInfo() {
    }

    /**
     * @param userid
     * @param tradeno
     * @param orderamount
     * @param realamount
     * @param channelid
     * @param outrradeno
     * @param type
     * @param remark
     * @param details
     */
    public OrderInfo(long userid,String userName, String tradeno, double orderamount, double realamount, long channelid, String
            outrradeno, int type, String remark, String details) {
        this.userid = userid;
        this.username=userName;
        this.tradeno = tradeno;
        this.orderamount = orderamount;
        this.realamount = realamount;
        this.channelid = channelid;
        this.outtradeno = outrradeno;
        this.type = type;
        this.status = OrderInfoConstants.Status.STATUS0.getStatus();
        this.remark = remark;
        this.details = details;
        this.updatetime = DateUtils.getTimeStr(new Date());
        this.createtime = DateUtils.getTimeStr(new Date());
    }

    @Id
    @GeneratedValue
    @Column(nullable = false, name = "order_id")
    private Long orderid;//订单编号
    @Column(nullable = false, name = "user_id")
    private Long userid;//用户编号
    @Column(nullable = true, name = "user_name")
    private String username;//用户名称
    @Column(nullable = false, unique = true, name = "trade_no")
    private String tradeno;//订单流水号
    @Column(nullable = false, name = "order_amount")
    private Double orderamount;//订单金额
    @Column(nullable = false, name = "real_amount")
    private Double realamount;//实际金额
    @Column(nullable = false, name = "channel_id")
    private Long channelid;//支付渠道标识
    @Column(nullable = true, name = "out_trade_no")
    private String outtradeno;//通道订单号
    @Column(nullable = false, length = 1)
    private Integer type;//类型
    @Column(nullable = false, length = 1)
    private Integer status;//状态
    @Column(nullable = true)
    private String remark;//备注
    @Column(nullable = false)
    private String details;//订单详情
    @Column(nullable = false, length = 19, name = "update_time")
    private String updatetime;//更新时间
    @Column(nullable = false, length = 19, name = "create_time")
    private String createtime;//创建时间

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }

    public Double getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(Double orderamount) {
        this.orderamount = orderamount;
    }

    public Double getRealamount() {
        return realamount;
    }

    public void setRealamount(Double realamount) {
        this.realamount = realamount;
    }

    public Long getChannelid() {
        return channelid;
    }

    public void setChannelid(Long channelid) {
        this.channelid = channelid;
    }

    public String getOuttradeno() {
        return outtradeno;
    }

    public void setOuttradeno(String outtradeno) {
        this.outtradeno = outtradeno;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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


}
