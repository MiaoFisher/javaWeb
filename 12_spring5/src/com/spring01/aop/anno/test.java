package com.spring01.aop.anno;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean7.xml");
        User user = classPathXmlApplicationContext.getBean("user", User.class);
        user.add();
    }
}
