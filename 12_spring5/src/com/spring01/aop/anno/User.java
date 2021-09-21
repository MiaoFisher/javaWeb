package com.spring01.aop.anno;

import org.springframework.stereotype.Component;

@Component
public class User {
    public void add(){
        //用于测试异常
//        int a = 1/0;
        System.out.println("in add()......");
    }
}
