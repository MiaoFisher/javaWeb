package com.spring01.service;

import org.springframework.stereotype.Service;

/**
 * 通过注解的方式去
 * Service的value是相当于配置文件中的id，可以省略，默认是类名首字母小写
 * @author ycc
 */
@Service
public class BookService {
    public void serviceMethod(){
        System.out.println("in service()");
    }
}
