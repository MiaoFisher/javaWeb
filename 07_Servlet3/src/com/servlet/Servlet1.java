package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get Parameter from form.html
        System.out.println("--------------post-------------------");
        //为了防止乱码 要将请求设置成UTF-8格式
        //要在获取请求之前调用才能生效
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("name: " + name);
        System.out.println("password: " + password);
        System.out.println("hobbies: "+ Arrays.asList(hobbies)) ;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get Parameter from form.html
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("name: " + name);
        System.out.println("password: " + password);
        System.out.println("hobbies: "+ Arrays.asList(hobbies)) ;
    }
}
