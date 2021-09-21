package com.service.impl;

import com.dao.OrderDao;
import com.dao.OrderItemDao;
import com.dao.impl.OrderDaoImpl;
import com.dao.impl.OrderItemDaoImpl;
import com.pojo.Cart;
import com.pojo.CartItem;
import com.pojo.Order;
import com.pojo.OrderItem;
import com.service.OrderService;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Override
    public String createOrder(Cart cart, int userId) {
        //创建订单编号（时间戳 + userId）,防止重复
        String orderId = System.currentTimeMillis() + "" + userId;
        //将订单项根据订单编号加入到订单中
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);
        //将map中的每个订单项
        for (CartItem cartItem:cart.getItems().values()){
//            int id, String name, BigDecimal price, BigDecimal totalPrice, String orderId, int count
            orderItemDao.saveOrderItem(new OrderItem(0,cartItem.getName(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId,cartItem.getCount()));
        }
        //将购物车清空
        cart.clear();
        return orderId;
    }

    /**
     * 根据用户订单查询订单项
     * @param orderId
     * @return
     */
    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        List<OrderItem> orderItems = orderItemDao.queryOrderDetails(orderId);
        return orderItems;
    }

    /**
     * 根据用户id查询用户所有订单
     * @param userId
     * @return
     */
    @Override
    public List<Order> queryOrdersByUserId(int userId) {
        List<Order> orders = orderDao.queryOrdersByUserId(userId);
        return orders;
    }

    @Override
    public void updateOrderStatusByOrderId(String  orderId, int status) {
        orderDao.changeOrderStatus(orderId,status);
    }

    /**
     * 返回所有用户的订单
     * @return
     */
    @Override
    public List<Order> queryAllOrders() {
        return orderDao.queryOrders();
    }


}
