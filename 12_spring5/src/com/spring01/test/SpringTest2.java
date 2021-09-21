package com.spring01.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.spring01.bean.Emp;
import com.spring01.bean.MyBean;
import com.spring01.bean.Stu;
import com.spring01.config.SpringConfig;
import com.spring01.service.BookService;
import com.spring01.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

public class SpringTest2 {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = classPathXmlApplicationContext.getBean("userService", UserService.class);
        userService.update();
    }
    @Test
    public void test2(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = classPathXmlApplicationContext.getBean("emp", Emp.class);
        System.out.println(emp);
    }
    @Test
    public void test3(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean4.xml");
        Stu stu = classPathXmlApplicationContext.getBean("stu", Stu.class);
        System.out.println(stu);

    }
    //测试bean生命周期
    @Test
    public void test4(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean4.xml");
        MyBean myBean = classPathXmlApplicationContext.getBean("myBean", MyBean.class);
        myBean.testMethod();
        //销毁容器
        classPathXmlApplicationContext.close();
    }
    @Test
    public void test5() throws SQLException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean5.xml");
        DruidDataSource dataSource = classPathXmlApplicationContext.getBean("dataSource", DruidDataSource.class);
        String url = dataSource.getUrl();
        System.out.println(url);
    }
    @Test
    public void test6(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean6.xml");
        BookService bookService = classPathXmlApplicationContext.getBean("bookService", BookService.class);
        bookService.serviceMethod();
    }
    @Test
    public void test7(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean6.xml");
        UserService userService = classPathXmlApplicationContext.getBean("userService", UserService.class);
        userService.update();
    }
    /**
     * 完全基于注解开发
     */
    @Test
    public void test8(){
        //在此处获取配置类
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = annotationConfigApplicationContext.getBean("userService", UserService.class);
        userService.update();
    }
}
