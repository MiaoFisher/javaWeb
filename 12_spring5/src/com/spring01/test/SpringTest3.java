package com.spring01.test;

import com.gdpowernode.WebUtils;
import com.spring01.dao.BookDao;
import com.spring01.dao.impl.BookDaoImpl;
import com.spring01.dao.impl.UserDaoImpl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * AOP测试
 */
public class SpringTest3 {
    @Test
    public void test1() {
        Class[] interfaces = {BookDao.class};
        BookDao bookDao = new BookDaoImpl();
        BookDao bookDao1 = (BookDao) Proxy.newProxyInstance(SpringTest3.class.getClassLoader(), interfaces, new ObjectProxy(bookDao));
        int add = bookDao1.add(1, 2);
        System.out.println("result:" + add);

    }
    @Test
    public void test3(){
        WebUtils webUtils = new WebUtils();
        String string = webUtils.getString();
        System.out.println(string);
    }
}

/**
 * jdk动态代理类
 */
class ObjectProxy implements InvocationHandler {
    //传递需要增强的参数
    Object object;
    public ObjectProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法执行之前
        System.out.println("方法执行之前,参数:" + Arrays.toString(args));
        //执行被增强的方法
        Object result = method.invoke(object, args);
        //方法执行之后
        System.out.println("方法执行之后 " + object);
        //放回结果
        return result;
    }

}
