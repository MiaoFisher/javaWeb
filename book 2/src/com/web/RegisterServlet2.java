package com.web;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet2 extends HttpServlet {
    //创建UserService提供数据库查询
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        //1. 获取表单得来的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        User user = new User(null,username,password,email);
        System.out.println(user);
        //2. 验证验证码(现在先验证是否为abcde),忽略大小写
        System.out.println(username);
        if (code.equalsIgnoreCase("abcde")){
            if (!userService.existUser(username)){
                //注册
                userService.registerUser(user);
                //注册后跳到成功界面
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }else {
                //用户不存在跳转回注册界面
                System.out.println("用户[" + username + "]已经存在存在");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }
        }else {
            System.out.println("验证码[" + code + "]错误");
            //验证失败跳回注册界面
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

