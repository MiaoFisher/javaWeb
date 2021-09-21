package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get Parameter form request Object
        String username = request.getParameter("username");
        //print it
        System.out.println("In servlet2, username: " + username);
        //get ServletContext Object
        ServletContext context = getServletContext();
        //save the Parameter
        context.setAttribute("username",username);
        //request Forward to servlet3
        request.getRequestDispatcher("/servlet3").forward(request,response);
        System.out.println("Back to servlet2");
    }
}
