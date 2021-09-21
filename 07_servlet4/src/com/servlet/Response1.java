package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("来自Response1");
        //第一种设置重定向的方法
//        来自Response1response.setStatus(302);
//        response.setHeader("Location","http://localhost:8080/07_servlet4/response2");
        //第二种设置重定向的方法
        response.sendRedirect("http://localhost:8080/07_servlet4/response2");
    }
}
