package com.spring01.service;

import com.spring01.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service()
public class UserService {
    /**
     * 根据属性类型去注入属性值
     */
    /**
     * 根据属性名注入(要配合@AutoWired使用使用)
     */
    @Autowired
    @Qualifier(value = "userDaoImpl")
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void update(){
        System.out.println("UserService中的update()方法");
        userDao.update();
    }
}
