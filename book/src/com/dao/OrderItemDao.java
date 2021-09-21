package com.dao;

import com.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    /**
     * 根据订单项保存订单
     * @param orderItem
     */
    public void saveOrderItem(OrderItem orderItem);
    /**
     * 根据订单编号查询订单明细
     */
    public List<OrderItem> queryOrderDetails(String orderId);
}
