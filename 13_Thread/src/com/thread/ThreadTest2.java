package com.thread;

/**
 * @author mxs
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        //使用匿名内部类的方式重写run()方法
        //该电脑在循环10000次的时候才会有“交替”，感受到线程并发执行
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {

                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}
