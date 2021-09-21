package com;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class servletTest implements Servlet {
    public servletTest() {
        System.out.println("1. Servlet的构造器方法");
    }

    /**
     * 这里执行初始化操作
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //ServletConfig对象的作用
        //1. get Servlet-name from xml file
        System.out.println("Servlet-name: "+servletConfig.getServletName());
        //2. get init configuration param from xml file
        System.out.println("init param(url): " + servletConfig.getInitParameter("url"));
        System.out.println("init param(username): " + servletConfig.getInitParameter("username"));
        //3. get ServletContext Object
        System.out.println("ServletContext Object: " + servletConfig.getServletContext());
        System.out.println("2. init()方法被调用");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service 是专门用来处理请求 和 响应
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3. 请求被响应了");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println(httpServletRequest.getMethod());
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy()被调用");
    }
}
