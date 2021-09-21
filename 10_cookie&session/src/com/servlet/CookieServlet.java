package com.servlet;

import com.sun.deploy.net.HttpRequest;
import com.utils.CookieUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {
    //创建cookie对象
    public void createCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.创建cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //2.将cookie通过response发送给客户端
        response.addCookie(cookie);
        response.getWriter().write("cookie 已经被创建了");
    }

    //查找cookie
    public void getCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取cookies数组
        Cookie[] cookies = request.getCookies();
        //
        Cookie cookie = CookieUtils.findCookie("key1", cookies);
        System.out.println(cookie.getName() + "=" + cookie.getValue());
    }

    //修改cookie
    public void updateCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //方法一
//        //创建一个新的cookie覆盖原来的cookie
//        Cookie cookie = new Cookie("key1", "newValue");
//        response.addCookie(cookie);
//        response.getWriter().write("cookie已经被修改了");
        //方法二：先查找原来的cookie，然后修改
        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
        //修改value
        cookie.setValue("newValue2");
        response.addCookie(cookie);
        response.getWriter().write("cookie通过第二种方式被修改");
    }

    public void defaultCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
        if (cookie != null) {
            //-1 是默认（关闭网页后自动删除(session)）
            cookie.setMaxAge(-1);
            //将cookie传到客户端中
            response.addCookie(cookie);
        }
    }

    public void deleteNow(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
        if (cookie != null) {
            //0 是立即删除该cookie
            cookie.setMaxAge(0);
            //将cookie回传到客户端
            response.addCookie(cookie);
        }

    }

    public void life3600(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
        if (cookie != null) {
            //将生命周期设为60秒 * 60 = 60分钟 = 1h
            cookie.setMaxAge(60 * 60);
            //将cookie回传到客户端
            response.addCookie(cookie);
        }
    }
    //设置cookie的路径
    public void testPath(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
        if (cookie != null) {
            //设置工程路径(修改路径)
            cookie.setPath(request.getContextPath() + "/abc");
            response.addCookie(cookie);
            response.getWriter().write("key1的工程路径已经被改变了");
        }
    }
    //保存用户名和密码
    public void saveUsernameAndPasswordByCookie(HttpServletRequest request,HttpServletResponse response){
        //在前端获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //判断用户名密码是否正确
        if (username.equals("sx") && password.equals("wbb")){
            //如果正确就各自给用户名和密码创建cookie
            Cookie usernameCookie = new Cookie("username", username);
            Cookie passwordCookie = new Cookie("password", password);
            usernameCookie.setMaxAge(60);
            passwordCookie.setMaxAge(60);
            //将cookie回传到客户端(server)
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);

        }
    }
}
