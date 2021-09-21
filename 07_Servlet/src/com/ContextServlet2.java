package com;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get ServletContext Object
        ServletContext context = getServletContext();
        //print it before save it
        System.out.println("before save it , name: " + context.getAttribute("name"));
        //context can save data like Map
        context.setAttribute("name","Peter");
        //print the data after set it
        System.out.println("name:" + context.getAttribute("name"));
    }
}
