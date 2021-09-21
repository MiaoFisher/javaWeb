package com.web;

import com.pojo.Cart;
import com.pojo.Order;
import com.pojo.OrderItem;
import com.pojo.User;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;
import com.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();
    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在session域中获取用户和购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("loginUser");
        //如果用户为空那么就跳转到登录界面
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        //生成订单并获取订单编号
        String orderId = orderService.createOrder(cart, loginUser.getId());
        //将订单编号保存到request中
        req.setAttribute("orderId",orderId);
        //跳转到成功生成订单界面
        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
    }

    /**
     * 用户查询自己的订单
     */
    public void queryOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在session域中获得登录的用户
        User loginUser = (User) req.getSession().getAttribute("loginUser");
        //如果用户为空那么就跳转到登录界面
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        //获取订单
        List<Order> orders = orderService.queryOrdersByUserId(loginUser.getId());
        //将订单保存到request域中
        req.setAttribute("orders",orders);
        //请求转发到order.jsp页面中
        req.getRequestDispatcher("pages/order/order.jsp").forward(req,resp);
    }

    /**
     * 根据订单编号查询用户订单项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void queryOrderItems(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //在请求中获取参数orderId
        String orderId = req.getParameter("orderId");
        //根据orderId获取订单项的列表
        List<OrderItem> orderItems = orderService.queryOrderItemsByOrderId(orderId);
        //将订单项列表保存到request中
        req.setAttribute("orderItems",orderItems);
        //请求转发到详情
        req.getRequestDispatcher("/pages/order/orderItem.jsp").forward(req,resp);
    }

    /**
     * 管理员查询所有用户的订单
     * @param request
     * @param response
     */
    public void queryAllOrders(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //从数据库中获取数据
        List<Order> orders = orderService.queryAllOrders();
        //保存到request域中
        request.setAttribute("orders",orders);
        //请求转发到jsp页面中
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }

    /**
     * 修改订单状态
     * @param request
     * @param response
     */
    public void updateOrderStatus(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取订单编号 和 修改后的状态
        String orderId = request.getParameter("orderId");
        int status = WebUtils.parseInt(request.getParameter("status"), 0);
        //在数据库中修改
        orderService.updateOrderStatusByOrderId(orderId,status);
        //重定向回到原来的界面
        response.sendRedirect(request.getHeader("Referer"));
    }


}
