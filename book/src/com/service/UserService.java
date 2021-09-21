package com.service;

import com.pojo.User;

//定义用户表的业务
public interface UserService {
    /**
     * 注册用户
     * @param user 新建的用户
     */
    public void registerUser(User user);

    /**
     *登录验证用户
     * @param user 验证的用户
     * @return 返回验证的用户
     */
    public User login(User user);

    /**
     * 判断是否存在该用户
     * @param username
     * @return
     */
    public boolean existUser(String username);

}
