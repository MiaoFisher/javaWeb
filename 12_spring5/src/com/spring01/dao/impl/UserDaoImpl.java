package com.spring01.dao.impl;

import com.spring01.dao.UserDao;
import org.springframework.stereotype.Component;

/**
 * 在此处使用了注解 配置了bean
 */
@Component(value = "userDaoImpl")
public class UserDaoImpl implements UserDao {
    @Override
    public void update() {
        System.out.println("UserDao中的update()方法");
    }
}
