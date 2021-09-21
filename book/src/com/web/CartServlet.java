package com.web;

import com.google.gson.Gson;
import com.pojo.Book;
import com.pojo.Cart;
import com.pojo.CartItem;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author ycc
 */
public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();
    /**
     * 添加商品到购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在请求中获取参数id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //在bookService中查询书本信息
        Book book = bookService.queryBookById(id);
        //将book中的信息放进商品中
        CartItem cartItem = new CartItem(id,book.getName(),1,book.getPrice());
        //现在session中获取cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        Object i1 = req.getSession().getAttribute("i");
        //如果没有那么就创建一个并将他保存打session中
        if ( cart== null) {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        //将数据添加到cart中
        cart.addItem(cartItem);
        System.out.println((Cart)req.getSession().getAttribute("cart"));
        //将最近的一次购物信息保存
        req.getSession().setAttribute("lastItems",cartItem);
        //重定向回到原来的界面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 删除购物车中的商品
     * @param request
     * @param response
     */
    public void deleteItems(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取参数id
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //在session中查找并获取cart
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            //删除这个商品
            cart.delete(id);
        }
        //重定向回到原来的界面
        response.sendRedirect(request.getHeader("Referer"));
    }
    /**
     * 清空购物车
     */
    public void clearCart(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //再session中获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            //将购物车清空
            cart.clear();
        }
        //重定向回到原来的界面
        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     *  修改购物车中商品的数量
     * @param request
     * @param response
     * @throws IOException
     */
    public void updateCart(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取参数id 和 count
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 1);
        //在session中获取cart参数
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            //修改count
            cart.update(id,count);
        }
        //重定向回到原来的界面
        System.out.println(request.getSession().getAttribute("cart"));
        response.sendRedirect(request.getHeader("Referer"));
    }
    /**
     * 使用ajax添加购物车
     */
    protected void ajaxAddItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在请求中获取参数id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //在bookService中查询书本信息
        Book book = bookService.queryBookById(id);
        //将book中的信息放进商品中
        CartItem lastItems = new CartItem(id,book.getName(),1,book.getPrice());
        //现在session中获取cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //如果没有那么就创建一个并将他保存打session中
        if ( cart== null) {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        //将数据添加到cart中
        cart.addItem(lastItems);
        System.out.println((Cart)req.getSession().getAttribute("cart"));
        //创建一个map将数据保存
        HashMap<String, Object> cartInfo = new HashMap<>();
        cartInfo.put("lastItems",lastItems.getName());
        cartInfo.put("totalCount",cart.getTotalCount());
        //将map转换为json
        Gson gson = new Gson();
        String json = gson.toJson(cartInfo);
        //在前端输出
        resp.getWriter().write(json);
    }
}
