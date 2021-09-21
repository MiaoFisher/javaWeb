package com.thread;

/**
 * @author mxs
 */
public class ThreadTest4 {
    public static void main(String[] args) {
        PropertiesThread propertiesThread = new PropertiesThread();
        /**
         * 设置线程的优先级
         * 默认级别都是5，数字越大代表优先级越高，但是优先级越高并不意味着先执行完该线程，只是执行该线程的概率会比较大
         * MAX_PRIORITY = 10 是最大的优先级
         * MIN_PRIORITY = 1 是默认最小的优先级
         */
        propertiesThread.setPriority(Thread.MAX_PRIORITY);
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        propertiesThread.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority()+":"+i);
            }
        }
    }
}

class PropertiesThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + this.getPriority() + ":" + i);
            }
        }
    }
}