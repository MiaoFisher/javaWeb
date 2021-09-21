package com.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
    /**
     * 根据的名称返回cookie对象
     * @param name 查找的的名字
     * @param cookies 查找的cookies数组
     * @return
     */
    public static Cookie findCookie(String name, Cookie[] cookies) {
        //如果name为空串则返回null
        if (name == "" || name == null || name.length() == 0) {
            return null;
        }
        //根据name查找cookie
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        //查找不到则返回null
        return null;
    }
}
