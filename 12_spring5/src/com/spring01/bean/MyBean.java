package com.spring01.bean;

/**
 * @author ycc
 */
public class MyBean {
    private String beanName;
    public MyBean(){
        System.out.println("第一步 通过构造器创建bean值");
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
        System.out.println("第二步 设置bean中的属性值");
    }
    public void testMethod(){
        System.out.println("第六步 使用bean");
    }
    /**
     * bean的初始化方法
     */
    public void initMethod(){
        System.out.println("第三步 bean的初始化方法");
    }
    /**
     * IOC容器销毁，bean同时销毁的方法
     */
    public void destroyMethod(){
        System.out.println("第七步 容器关闭,bean销毁");
    }

}
