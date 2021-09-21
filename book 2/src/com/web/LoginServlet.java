package com.web;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//用于处理登录验证的请求
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //根据用户名和密码判断
        if (userService.login(new User(null,username,password,null))==null){
            //验证失败则跳转到登录界面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else {
            //登录成功跳转到成功界面
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
