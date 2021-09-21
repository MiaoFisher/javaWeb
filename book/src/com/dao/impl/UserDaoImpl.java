package com.dao.impl;

import com.dao.BaseDao;
import com.dao.UserDao;
import com.pojo.User;

import java.util.List;

public class UserDaoImpl  extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        User user = queryForOne(User.class, sql, username);
        return user;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        int updateCount = update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        return updateCount;
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        User user = queryForOne(User.class, sql, username, password);
        return user;
    }
}
