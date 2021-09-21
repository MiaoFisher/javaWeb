package com.thread.ticketProblem;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mxs
 * 方式3 解决线程安全的问题
 * 使用lock的方式去解决  --- jdk5.0新增的特性
 * 【重要】使用lock方法和synchronized的异同
 * 1.相同：synchronized和lock都可以解决线程安全的同步问题
 * 2.不同: synchronized机制在执行完相应同步代码之后，自动释放同步监视器（锁）
 *         lock机制需要手动启动lock(),同步结束同样需要释放资源unlock()
 * 【建议】优先使用lock机制
 */
public class TicketProblem5 {
    public static void main(String[] args) {
        Window5 w = new Window5();
        Thread w1 = new Thread(w);
        Thread w2 = new Thread(w);
        Thread w3 = new Thread(w);
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}

class Window5 implements Runnable {
    public int count = 1000;
    //创建锁
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //调用方法锁定lock
                lock.lock();
                if (count > 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    count--;
                } else {
                    break;
                }
            } finally {
                //需要手动释放lock
                lock.unlock();
            }
        }
    }
}
