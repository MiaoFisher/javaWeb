package com.test;

import com.dao.OrderDao;
import com.dao.OrderItemDao;
import com.dao.impl.OrderDaoImpl;
import com.dao.impl.OrderItemDaoImpl;
import com.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(0,"java",new BigDecimal(15),new BigDecimal(15),"1234",15));
    }

    @Test
    public void queryOrderDetails() {
    }
}