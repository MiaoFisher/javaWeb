package com.dao;

import com.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

/**
 * @author ycc
 * Order的Dao层的接口
 */
public interface OrderDao {
    /**
     * 保存订单
     * @param order 需要保存的订单
     * @return
     */
    public int saveOrder(Order order);

    /**
     * 查询所有订单
     * @return 返回订单中所有Order的集合
     */
    public List<Order> queryOrders();

    /**
     * 修改订单状态
     * @param orderId 要修改订单的编号
     * @param status 修改的状态
     */
    public void changeOrderStatus(String orderId,int status);

    /**
     * 根据用户id查找订单
     * @param userId 用户id
     * @return 返回用户所有的订单(以集合的形式)
     */
    public List<Order> queryOrdersByUserId(int userId);
}
