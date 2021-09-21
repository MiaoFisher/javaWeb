package com.filter;

import com.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * 该过滤器用于进行事务管理
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
//            //提交事务
//            JDBCUtils.commitAndClose();
        } catch (Exception e) {
            //如果出现异常那么就回滚
//            JDBCUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void destroy() {

    }
}
