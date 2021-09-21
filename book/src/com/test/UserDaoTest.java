package com.test;

import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    //测试UserDaoImpl
    UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        User user = userDao.queryUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setUsername("冰冰");
        user.setPassword("bingbing");
        user.setEmail("bingbing@xs.com");
        int i = userDao.saveUser(user);
        System.out.println(i);
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("admin", "admin");
        System.out.println(user);
    }
}