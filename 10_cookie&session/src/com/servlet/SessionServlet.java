package com.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ycc
 */
public class SessionServlet extends BaseServlet{
    public void createSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //创建/得到已有的session
        HttpSession session = request.getSession();
        //判断该session是新创建的还是已经创建好了的
        boolean aNew = session.isNew();
        response.getWriter().write("session" + session + "<br/>");
        response.getWriter().write("sessionId" + session.getId() + "<br/>");
        response.getWriter().write("是否为新建的session:" + aNew);
    }
    //在session中保存对象
    public void setAttribute(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        //王session中存放数据
        session.setAttribute("key1","value1");
        response.getWriter().write("已经往session中存放数据");
    }
    /***
     * 在session中获取数据
     * @param request
     * @param response
     * @throws IOException
     */
    public void getAttribute(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        //从session域中存放数据
        Object key1 = session.getAttribute("key1");
        response.getWriter().write("从key1中去取出来的数据为:"+String.valueOf(key1));
        session.getMaxInactiveInterval();
    }
    public void getSessionDefaultInfo(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获得超时时间
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        response.getWriter().write("session超时时间为:"+maxInactiveInterval);
    }
    public void life3(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //将超时时长改为3s
        request.getSession().setMaxInactiveInterval(3);
        response.getWriter().write("session超时时长已经更改为3s");
    }
    public void deleteNow(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //将session马上超时（删除）
        request.getSession().invalidate();
        response.getWriter().write("session已经被删除");

    }

}
