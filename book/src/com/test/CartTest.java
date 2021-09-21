package com.test;

import com.pojo.Cart;
import com.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 用于测试cart中的各种方法
 * @author ycc
 * @date 2021.8.9
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        //cart.addItem(new CartItem(1,"文学",10,new BigDecimal(999)));
        System.out.println(new CartItem(1,"文学",10,new BigDecimal(999)));
        cart.addItem(new CartItem(2,"天文",10,new BigDecimal(999)));
        cart.addItem(new CartItem(1,"文学",10,new BigDecimal(999)));

    }

    @Test
    public void delete() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"文学",10,new BigDecimal(999)));
        //System.out.println(new CartItem(1,"文学",10,new BigDecimal(999)));
        cart.addItem(new CartItem(2,"天文",10,new BigDecimal(999)));
        cart.addItem(new CartItem(1,"文学",10,new BigDecimal(999)));
        cart.delete(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"文学",10,new BigDecimal(999)));
        cart.addItem(new CartItem(2,"天文",10,new BigDecimal(999)));
        cart.addItem(new CartItem(1,"文学",10,new BigDecimal(999)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void update() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"文学",10,new BigDecimal(999)));
        cart.addItem(new CartItem(2,"天文",10,new BigDecimal(999)));
        cart.addItem(new CartItem(1,"文学",10,new BigDecimal(999)));
        cart.update(1,5);
        System.out.println(cart);
    }
}