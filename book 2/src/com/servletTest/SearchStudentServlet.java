package com.servletTest;

import com.pojo.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> list = new ArrayList<Customer>();
        for (int i = 0;i<10;i++){
            list.add(new Customer(i+1,"name"+(i+1),"email"+(i+1),new Date(1549845126L+i)));
        }
        //将数据保存到request中
        req.setAttribute("list",list);
        req.getRequestDispatcher("/test2.jsp").forward(req,resp);
    }
}
