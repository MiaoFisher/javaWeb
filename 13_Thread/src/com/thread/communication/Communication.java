package com.thread.communication;

/**
 * @author mxs
 * 线程通信中的使用到的方法
 * wait()---让当前线程处于阻塞状态
 * notify()---唤醒阻塞状态中的一个线程（根据优先级唤醒，如果优先级相同就随机唤醒一个线程）
 * notifyAll()---唤醒阻塞状态中的线程
 * 使用上面的方法的对象必须是同一把锁(同一个同步监视器)
 * 否则会爆出java.lang.IllegalMonitorStateException
 * 值得注意的是以上三种方法都是java.lang.Object中的方法，因为锁可以是任意一个对象
 *
 */
public class Communication {
    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
        Thread thread1 = new Thread(printNum);
        Thread thread2 = new Thread(printNum);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();


    }
}

class PrintNum implements Runnable {
    private int num = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                //唤醒处于阻塞状态的一个线程
                this.notify();
                if (num <= 1000) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    try {
                        //将当前线程处于阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
