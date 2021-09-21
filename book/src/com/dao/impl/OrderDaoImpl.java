package com.dao.impl;

import com.dao.BaseDao;
import com.dao.OrderDao;
import com.pojo.Order;

import java.math.BigDecimal;
import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    /**
     *
     * @param order 需要保存的订单
     * @return
     */
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id)values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select order_id orderId,create_time createTime,price,status,user_id userId from t_order ";
        return queryForList(Order.class,sql);
    }

    /**
     * 修改订单状态
     * @param orderId 要修改订单的编号
     * @param status 修改的状态
     */
    @Override
    public void changeOrderStatus(String orderId, int status) {
        String sql = "update t_order set status = ? where order_id = ?";
        update(sql,status,orderId);
    }

    @Override
    public List<Order> queryOrdersByUserId(int userId) {
//        String orderId, Date createTime, BigDecimal price, int status, int userId
        String sql = "select order_id orderId,create_time createTime,price,status,user_id userId from t_order where user_id=?";
        return queryForList(Order.class,sql,userId);
    }
}
