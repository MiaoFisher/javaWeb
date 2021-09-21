package com.thread.lazyPattern;

import sun.awt.windows.ThemeReader;

/**
 * @author mxs
 * 本类将使用【线程同步】的方式去写【懒汉式】的【单例模式】
 * 解决线程安全问题
 */
public class Test1 {
    public static void main(String[] args) {
        //创建实例instance
        Bank instance = Bank.getInstance2();
        Bank instance1 = Bank.getInstance2();
        //测试hashcode是否相同
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());


    }
}

class Bank {
    private Bank() {
    }

    private static Bank instance;

    public static Bank getInstance() {
//        //方式1,这种方法运行的效率比较低,因为每一次都要进入同步判断，运行效率低
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//                return instance;
//            }
//            return instance;
//        }
        //方式2，先判断instance是否为空,如果不为空就可以不用进入同步，效率比较高
        if (instance == null){
            synchronized (Bank.class){
                instance = new Bank();
                return instance;
            }
        }return instance;
    }
    //方式3，可以直接在方法中直接添加synchronized
    public static synchronized Bank getInstance2(){
        if (instance == null){
            instance = new Bank();
            return instance;
        }return instance;
    }
}
