package com.thread;

import java.util.LinkedList;

/**
 * 使用Runnable创建线程
 *
 * @author mxs
 */
public class RunnableTest {
    public static void main(String[] args) {
        //创建实现类对象
        RThread rThread = new RThread();
        //将这个对象传入Thread类的构造器中，创建Thread对象
        Thread thread = new Thread(rThread);
        //通过Thread类的对象调用start()方法
        //new Thread(Runnable runnable)的时候传入了Runnable对象
        //Thread对象在使用start()方法的时候会调用线程内的run()方法
        //start()方法的两作用:1.创建新的线程,2.调用线程中的run()方法
        /**
         * Thread源码中的代码
         * target类型就是Runnable,所以Thread会调用传入Runnable对象中的run()方法
         * public void run() {
         *         if (target != null) {
         *             target.run();
         *         }
         *     }
         */
        thread.setName("线程1");
        //创建第二个线程只需要new Thread()就可以了，不需要重新创建Runnable对象
        Thread thread1 = new Thread(rThread);
        thread1.setName("线程2");
        thread.start();
        thread1.start();

    }
}

/**
 * 创建Runnable对象
 */
class RThread implements Runnable {
    LinkedList linkedList = new LinkedList();
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

}
