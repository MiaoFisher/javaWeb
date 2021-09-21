package com.thread;

/**
 * @author mxs
 * yield()方法
 */
public class ThreadTest3 {
    public static void main(String[] args) throws InterruptedException {
        HelloThread helloThread = new HelloThread();
        //可以直接通过setName()来修改线程的名字
        helloThread.setName("线程1");
        helloThread.start();
        //xxxThread.isAlive()判断线程是否还存活
        System.out.println("++++++++++" + helloThread.isAlive());
        for (int i =0;i<100;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
            if (i == 20){
//                try {
//                    //join()方法，让该线程先执行完成
//                    helloThread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                //Thread.yield()释放cpu资源
                //可能会让切换线程执行
                Thread.yield();
                //Thread.sleep()让线程睡眠,单位是毫秒（也就是1000ms = 1s）
//                Thread.sleep(2000);
            }
        }
        //在构造方法中直接修改线程的名字
        new Thread("线程2") {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}