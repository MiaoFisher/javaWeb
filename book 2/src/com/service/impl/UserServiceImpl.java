package com.service.impl;

import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import com.service.UserService;
import org.junit.Test;

public class UserServiceImpl extends UserDaoImpl implements UserService {
    @Override
    public void registerUser(User user) {
        saveUser(user);
    }

    @Override
    public User login(User user) {
        return queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUser(String username) {
        if (queryUserByUsername(username) == null) {
            return false;
        } else {
            return true;
        }
    }

}
