package com.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ycc
 * 订单的pojo类
 */
public class Order {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 订单创建时间
     */
    private Date createTime;
    /**
     * 订单价格
     */
    private BigDecimal price;
    /**
     * 订单状态  0-未发货 1-已发货 2-已签收
     */
    private int status;
    /**
     * 用户id
     */
    private int userId;
    public Order(){

    }
    public Order(String orderId, Date createTime, BigDecimal price, int status, int userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
