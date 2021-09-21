package com.service;

import com.pojo.Cart;
import com.pojo.Order;
import com.pojo.OrderItem;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

/**
 * Order模块的service
 */
public interface OrderService {
    /**
     * 根据购物车中的信息和用户id创建订单
     *
     * @param cart
     * @param userId
     * @return 返回订单编号
     */
    public String createOrder(Cart cart,int userId);

    /**
     * 根据订单编号查询订单详细（每个订单项）
     * @param OrderId
     * @return
     */
    public List<OrderItem> queryOrderItemsByOrderId(String OrderId);

    /**
     * 根据用户id查询用户订单
     * @param userId
     * @return
     */
    public List<Order> queryOrdersByUserId(int userId);

    /**
     * 根据OrderId修改订单状态
     * @param orderId
     * @param status
     */
    public void updateOrderStatusByOrderId(String orderId,int status);

    public List<Order> queryAllOrders();
}
