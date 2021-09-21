package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 这个servlet用来解决response对象输出的时候中文乱码
 */
public class Servlet5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //there are two way to solve Chinese disorderly code in Web application
        //way 1
//        //1.1 set server CharacterEncoding = UTF-8
//        response.setCharacterEncoding("UTF-8");
//        //1.2 by setting response head, to set browser CharacterEncoding also equal UTF-8
//        response.setHeader("Content-Type","text/html;charset=UTF-8");
        //way 2 set contentType, it can set both server's CharacterEncoding and request header's CharacterEncoding
        response.setContentType("text/html;charset=UTF-8");
        //get Output Object from Response Object
        PrintWriter printWriter = response.getWriter();
        //print it in web page
        printWriter.write("响应");
    }
}
