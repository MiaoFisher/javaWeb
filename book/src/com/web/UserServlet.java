package com.web;

import com.google.gson.Gson;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.utils.WebUtils;
import com.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author ycc
 */
//这里用于处理所有User模块的信息
public class UserServlet extends BaseServlet {
    //用于处理登录的请求
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        //获得参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //根据用户名和密码判断
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            //将错误的信息传输到jsp页面中
            request.setAttribute("msg", "用户名或密码错误");
            //保存回显信息
            request.setAttribute("username", username);
            //验证失败则跳转到登录界面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            //将用户信息保存到session域中
            request.getSession().setAttribute("loginUser", loginUser);
            //登录成功跳转到成功界面
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    /**
     * 处理注销的操作
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取session并且将他销毁
        request.getSession().invalidate();
        //重定向到首页
        response.sendRedirect(request.getContextPath());
    }

    //用于处理注册的请求
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        //1. 获取表单得来的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
//        User user = new User(null,username,password,email);
        //通过request.getParameterMap()获取request中的参数，是以Map的形式返回(key1=value1,key2=value2,key3=value3)
        //通过调用该方法可以将Map中的参数注入到bean中
        //【注意】request中的变量名要和bean中setxxxx()对应，否则可能无法注入
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        System.out.println(user);
        //保存username 和 email 以便错误时候回传
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        //获取验证码(谷歌验证码,导入了KAPTCHA.jar)
        String kapchaCode = (String)request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //获得验证码之后马上在session中删除该验证码，防止重复提交
        request.removeAttribute(KAPTCHA_SESSION_KEY);
        //2. 验证验证码,忽略大小写
        //验证验证码是否为空 以及验证验证码是否正确
        if (kapchaCode!=null && code.equalsIgnoreCase(kapchaCode)) {
            if (!userService.existUser(username)) {
                //注册
                userService.registerUser(user);
                //注册后跳到成功界面
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            } else {
                //将用户名重复的错误提示信息回传
                request.setAttribute("msg", "用户名[ " + username + " ]已经存在");
                System.out.println("用户[" + username + "]已经存在存在");
                //用户不存在跳转回注册界面
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            }
        } else {
            //将验证码错误提示信息回传
            request.setAttribute("msg", "验证码错误");
            System.out.println("验证码[" + code + "]错误");
            //验证失败跳回注册界面
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }
    /**
     * 利用ajax请求来判断用户名是否合法
     */
    public void ajaxExistUsername(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //在前端获取参数
        String username = request.getParameter("username");
        UserService userService = new UserServiceImpl();
        //判断用户名是否存在
        boolean existUser = userService.existUser(username);
        //将返回的结果封装成Map，便于转换为json
        Map<String,Object> result = new HashMap<>();
        result.put("existUser",existUser);
        //将map转换为json传送到前端
        Gson gson = new Gson();
        String json = gson.toJson(result);
        //在前端输出
        response.getWriter().write(json);
    }


}
