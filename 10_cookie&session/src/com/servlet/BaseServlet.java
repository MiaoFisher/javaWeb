package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

//这是Servlet的公共代码部分
public abstract class BaseServlet extends HttpServlet {
    //通过该方法去调用servlet中对应的方法
    //需要注意，当请求是get的时候,需要在doGet()中调用doPost()
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求 和 响应 的 编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //通过请求获取action，即调用的方法
        String action = req.getParameter("action");
        try {
            //通过反射 根据action获取响应业务的方法
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //调用响应的业务方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //通过doGet()调用doPost()
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
