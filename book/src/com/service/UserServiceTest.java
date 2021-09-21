package com.service;

import com.pojo.User;
import com.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    //测试UserServiceImpl类
    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"1234","miaomiao","miao@xs.com"));
    }
    @Test
    public void login() {
        User login = userService.login(new User(null, "admin", "admin", null));
        System.out.println(login);
    }
    @Test
    public void existUser() {
        System.out.println(userService.existUser("yangqian"));
    }
}