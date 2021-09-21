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
        System.out.println("到此一游 Response1");
        //set status code - 302 means request redirect
        response.setStatus(302);
        //set header's location, and set redirect path
        response.setHeader("Location","http://localhost:8080/07_servlet2/response2");
    }
}
