package com.thread;

/**
 * @author mxs
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        //创建线程
        MyThread myThread = new MyThread();
        //调用start()方法使用线程中的run方法
        //启动线程只能调用run()这个方法
        //start()方法的作用：1.启动线程 2.使用线程中的start()方法
        //如果仅仅使用myThread.run()方法，就不会创建多一个线程，就会仅仅先执行run()然后再执行main中的其他内容（在他后面的代码）
        myThread.start();
        //同一个线程只能使用一次start(),否则会报线程使用异常错误,因为第一次使用start()这个方法，threadStatus就会变为1，下一次执行这个方法就会抛出异常 IllegalThreadStateException
        //
        //如果需要创建多个线程需要创建新一个线程类
        MyThread myThread1 = new MyThread();
        myThread1.start();
        //以下方法仍然是在线程中使用的
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

/**
 * 重写线程
 */
class MyThread extends Thread {
    //重写run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
