package com.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author mxs
 第四种方式创建线程:通过线程池去创建线程
【优势】
    1.提高了相应速度（减少了创建线程的时间）
    2.降低了资源消耗(重复利用线程中的线程，不需要每次都要重新创建)
    3.便于线程管理
        可以管理如：核心池大小，最大线程数量,线程在保持多久时间后会终止
 */
public class PoolThread {
    public static void main(String[] args) {
        //通过Executors.newFixedThreadPool()创建ExecutorService（线程池）
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //为了设置其他属性，需要获取线程池的实现类
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        //threadPoolExecutor.execute(Runnable command)用于启动Runnable对象中的run()方法
        //threadPoolExecutor.submit()用于启动实现Callable对象中的call()方法
        threadPoolExecutor.execute(new MyThread1());
        threadPoolExecutor.execute(new MyThread1());
    }
}

class MyThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
