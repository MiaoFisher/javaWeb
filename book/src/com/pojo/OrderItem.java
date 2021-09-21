package com.pojo;

import java.math.BigDecimal;

/**
 * @author ycc
 * 订单项（订单中的各个项目）的pojo类
 */
public class OrderItem {
    /**
     * 订单项编号(自动生成)
     */
    private int id;
    /**
     * 商品名
     */
    private String name;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 总价
     */
    private BigDecimal totalPrice;
    /**
     * 所属订单编号
     */
    private String orderId;
    /**
     * 商品数量
     */
    private int count;
    public OrderItem(){

    }
    public OrderItem(int id, String name, BigDecimal price, BigDecimal totalPrice, String orderId, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
