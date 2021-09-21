package com.pojo;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 这是购物车中每一个商品
 * @author ycc
 */
public class CartItem {
    private int id;
    private String name;
    private Integer count;
    private BigDecimal price;


    public CartItem(int id, String name, Integer count, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;

    }

    public CartItem() {
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {

        return this.price.multiply(new BigDecimal( this.getCount() ));
    }


    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }


}
