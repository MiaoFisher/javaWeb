package com.Relection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.Properties;

public class ReflectionTest {
    //创建实例测试
    @Test
    public void test() throws ClassNotFoundException {
        //总共有四种通过反射创建实例方法
        //1.通过调用运行时类的属性.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //2.通过调用运行时类的对象 通过getClass()
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);
        //3.通过forName()的方法 Class.forName("报名")
        Class clazz3 = Class.forName("com.Relection.Person");
        System.out.println(clazz3);
        //4.通过类加载器getClassLoader
        //但是注意下面的这一种方法在tomcat服务器不可用，详细在网页收藏
        Class clazz4 = ClassLoader.getSystemClassLoader().loadClass("com.Relection.Person");
        System.out.println(clazz4);
        //这样写才可以,原因大概是getSystemClassLoader()不能找到当前对应的运行类
        Class clazz5 = ReflectionTest.class.getClassLoader().loadClass("com.Relection.Person");
        System.out.println(clazz5);
        System.out.println(clazz4 == clazz5);
    }

    //读取配置文件的方式
    //方式1：根据Properties自带的load()方法读取
    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        //这里的默认配置文件实在module下
        FileInputStream fis = new FileInputStream("test2.properties");
        properties.load(fis);
        System.out.println("username:" + properties.getProperty("user"));
        System.out.println("password:" + properties.getProperty("password"));
    }

    //方式2: 通过ClassLoader读取
    @Test
    public void test3() throws IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        //通过getResourceAsStream() 以流的方式去获取配置文件信息
        //默认配置文件路径是在src下
        //值得注意【配置文件】不能复制粘贴的来，否则可能会报空指针异常
        InputStream is = classLoader.getResourceAsStream("test4.properties");
        properties.load(is);
        System.out.println("username:" + properties.getProperty("username"));
        System.out.println("password:" + properties.getProperty("password"));
    }

    //通过newInstance()创建实例
    //调用此方法，创建对应的运行时类。内部调用了运行时类的【空参】构造方法
    //所以要想用这个方法正常的创建运行时类，要求
    //1.运行时类提供空参的构造器
    //2.空参的构造器的访问权限够，通常设置为public
    @Test
    public void test4() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        System.out.println(person);
    }
    //获取运行时类的属性参数
    @Test
    public void test5() {
        Class clazz = Person.class;
        //getFields()获取运行时类及其父类的【public】参数
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("=============================================");
        //getDeclaredFields()获取运行时类的【所有】参数(不包含父类)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //打印参数属性
            System.out.println(declaredField);
            //获得参数权限类型
            int modifiers = declaredField.getModifiers();
            System.out.println(Modifier.toString(modifiers));
            //获取参数类型
            System.out.println(declaredField.getType());
            //获取参数名
            System.out.println(declaredField.getName());
        }
    }
    //获取运行时类的方法
    @Test
    public void test6(){
        Class<Person> clazz = Person.class;
        //getMethods()获取运行时类及其父类的所有【public】方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("=========================================");
        //getDeclaredMethods()获取所有运行时类的所有方法，不包含父类
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
    //通过反射调用指定结构
    //1.通过反射调用指定【属性】
    @Test
    public void test7() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        //获取Class的实例
        Class<Person> clazz = Person.class;
        //创建实例对象
        Person p = clazz.newInstance();
        //获取指定【public】属性（包含父类）
//        //但通常不用这种方式，因为很少用public声明
//        Field id = clazz.getField("id");
//        //设置当前属性的值
//        /**
//         * 第一个参数：哪一个对象的属性
//         * 第二个参数：属性值
//         */
        //通过getDeclaredField()可以获取对象中的所有属性（不包含父类），是开发中常用的方式
        Field name = clazz.getDeclaredField("name");
        //将获取到的属性的访问权限改为true，保证可以设置除了 public以外的属性
        name.setAccessible(true);
        //        //设置当前属性的值
//        /**
//         * 第一个参数：哪一个对象的属性
//         * 第二个参数：属性值
//         */
        name.set(p,"1005");
        System.out.println(p.getName());
    }
    //【！！！重点需要掌握！！！】
    //通过反射调用对象的【方法】
    @Test
    public void test8() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //创建Class实例
        Class<Person> clazz = Person.class;
        //创建实例对象
        Person person = clazz.newInstance();
        //获取实例对象的方法，第一个参数是方法名，后面的参数是属性
        Method getNation = clazz.getDeclaredMethod("getNation", String.class);
        //将访问权限改为true
        getNation.setAccessible(true);
        //执行方法,获取返回值
        Object returnValue = getNation.invoke(person, "中国");
        System.out.println(returnValue);
        //调用静态的方法(和上面类似)
        Method getMoney = clazz.getDeclaredMethod("getMoney");
        //将权限打开
        getMoney.setAccessible(true);
        //对象参数可以省略
        Object invoke = getMoney.invoke(null);
        System.out.println(invoke);
    }
    //通过反射调用对象指定构造器
    @Test
    public void test9() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //创建Class实例
        Class<Person> clazz = Person.class;
        //通过 参数 获取构造器
        Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor(int.class);
        //将declaredConstructor权限打开
        declaredConstructor.setAccessible(true);
        //调用这个构造器
        Person person = declaredConstructor.newInstance(15);
        System.out.println(person);
    }
}
