package com.filter;

import com.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //将ServletRequest强制转换为HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        //在session中获取loginUser对象
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            //如果session中没有loginUser那么就跳转到登录界面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            //如果有就放行
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
