package com.ajaxTest;

import com.google.gson.Gson;
import com.jsonTest.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ycc
 */
public class AjaxServlet extends BaseServlet{
    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax请求过来了");

        //传到服务器那里的数据必须是字符串，因此这里直接将数据转换成为json再传递
        Gson gson = new Gson();
        String toJsonString = gson.toJson(new Person(1, "李华"));
        //将json数据传送到服务器中
        resp.getWriter().write(toJsonString);
    }
    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryAjax请求过来了");
        //传到服务器那里的数据必须是字符串，因此这里直接将数据转换成为json再传递
        Gson gson = new Gson();
        Person person = new Person(1, "李华");
        String toJsonString = gson.toJson(person);
        System.out.println(toJsonString);
        //将json数据传送到服务器中
        resp.getWriter().write(toJsonString);
    }
    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryGet请求过来了");
        //传到服务器那里的数据必须是字符串，因此这里直接将数据转换成为json再传递
        Gson gson = new Gson();
        Person person = new Person(1, "李华");
        String toJsonString = gson.toJson(person);
        System.out.println(toJsonString);
        //将json数据传送到服务器中
        resp.getWriter().write(toJsonString);
    }
    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryPost请求过来了");
        //传到服务器那里的数据必须是字符串，因此这里直接将数据转换成为json再传递
        Gson gson = new Gson();
        Person person = new Person(1, "李华");
        String toJsonString = gson.toJson(person);
        System.out.println(toJsonString);
        //将json数据传送到服务器中
        resp.getWriter().write(toJsonString);
    }
    protected void jQueryGetJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryGetJson请求过来了");
        //传到服务器那里的数据必须是字符串，因此这里直接将数据转换成为json再传递
        Gson gson = new Gson();
        Person person = new Person(1, "李华");
        String toJsonString = gson.toJson(person);
        System.out.println(toJsonString);
        //将json数据传送到服务器中
        resp.getWriter().write(toJsonString);
    }
    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerySerialize");
        //传到服务器那里的数据必须是字符串，因此这里直接将数据转换成为json再传递
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
    }
}
