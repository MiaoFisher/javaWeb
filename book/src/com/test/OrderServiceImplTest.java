package com.test;

import com.pojo.*;
import com.service.BookService;
import com.service.OrderService;
import com.service.impl.BookServiceImpl;
import com.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceImplTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        BookService bookService = new BookServiceImpl();
        Book book = bookService.queryBookById(2);
        cart.addItem(new CartItem(2,"数据结构与算法2",15,book.getPrice()));
        cart.addItem(new CartItem(2,"数据结构与算法2",15,book.getPrice()));
        cart.addItem(new CartItem(8,"Java编程思想",10,new BigDecimal(47)));
        OrderService orderService = new OrderServiceImpl();
        String order = orderService.createOrder(cart, 1);
        System.out.println(order);
    }

    @Test
    public void queryOrderItemsByOrderId() {
        OrderService orderService = new OrderServiceImpl();
        List<OrderItem> orderItems = orderService.queryOrderItemsByOrderId("16285718509061");
        orderItems.forEach(System.out::println);
    }
    @Test
    public void queryOrdersById(){
        OrderService orderService = new OrderServiceImpl();
        List<Order> orders = orderService.queryOrdersByUserId(1);
        orders.forEach(System.out::println);
    }
    @Test
    public void updateOrderStatusByOrderId(){
        OrderService orderService = new OrderServiceImpl();
        orderService.updateOrderStatusByOrderId("16285288565651",2);
    }

}