package com.test;

import com.dao.OrderDao;
import com.dao.impl.OrderDaoImpl;
import com.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoImplTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("123", new Date(new java.util.Date().getTime()), new BigDecimal(100), 0, 1));
    }

    @Test
    public void queryOrders() {
    }

    @Test
    public void changeOrderStatus() {
    }

    @Test
    public void queryOrdersByUserId() {
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> orders = orderDao.queryOrdersByUserId(1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}