package com.dao.impl;

import com.dao.BaseDao;
import com.dao.OrderItemDao;
import com.pojo.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    /**
     * 保存用户订单项
     * @param orderItem 需要保存的订单项
     */
    @Override
    public void saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderDetails(String orderId) {
        String sql = "select id,name,count,price,total_price totalPrice,order_id orderId from t_order_item where order_Id = ?";
        List<OrderItem> orderItems = queryForList(OrderItem.class, sql, orderId);
        return orderItems;
    }
}
