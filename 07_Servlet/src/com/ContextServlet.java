package com;

import javax.security.auth.login.Configuration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //remember to check method (get or post)
        //get the ServletContext Object
        ServletContext context = getServletConfig().getServletContext();
        // 1 get Context Parameter
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        // 2 get WehRealPath
        System.out.println("Program webRealPath: " + context.getRealPath("/"));
        System.out.println("a.html webRealPath: " + context.getRealPath("/a.html"));
        //3. getContextPath in dick
        System.out.println("" + context.getContextPath());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
