package com.thread.ticketProblem;

/**
 * @author mxs
 * 在java中用同步来解决线程安全问题
 * 方式1：
 * 使用同步代码块的方式执行
 * synchronized(同步监视器){
 * //需要被同步的代码
 * }
 * 说明:1.操作共享数据的代码，即为需要同步的代码
 * 2.共享数据:多个变量共享的数据，比如:count就是共享数据
 * 3.同步监视器:锁，任何一个类的对象都可以作为锁，而且【重要】多个线程必须使用同一把锁，否则将无法同步
 */
public class TicketProblem1 {
    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {
    private int count = 100;
    //同步监视器必须作为成员变量，即必须在run()方法外部，否则将无法共享同一把锁
    Lock lock = new Lock();

    @Override
    public void run() {
        //synchronized:同步
        while (true) {
            //如果是用Runnable接口实现的run()方法，可以直接使用this对象作为锁
            synchronized (this) {
                if (count > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    count--;
                }else {
                    break;
                }

            }
        }
    }
}

class Lock {
}

