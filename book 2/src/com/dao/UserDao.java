package com.dao;

import com.pojo.User;

import java.util.List;

public interface UserDao {

    //根据用户名查询用户
    public User queryUserByUsername(String username);
    //添加新用户
    public int saveUser(User user);
    //根据用户名和密码查询用户
    public User queryUserByUsernameAndPassword(String username, String password);
}
