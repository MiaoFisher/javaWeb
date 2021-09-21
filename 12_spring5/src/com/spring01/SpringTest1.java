package com.spring01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Target;

public class SpringTest1 {
    @Test
    public void testSpring(){
        //获得配置文件，记得一定要在src路径下
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }
    @Test
    public void testSpringIoc(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        //通过构造器/setxxx() 的方式在xml配置文件中注入属性
        Book book = classPathXmlApplicationContext.getBean("book", Book.class);
        System.out.println(book);
    }

}
