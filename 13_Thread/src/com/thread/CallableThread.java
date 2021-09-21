package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用CallableThread的方式创建线程 --- jdk5.0的新特性
 * 【重要】使用Callable创建线程的优势
 * 1.call()可以有返回值
 * 2.call()可以抛出异常，被外面捕获，获取异常信息
 * @author mxs
 */
public class CallableThread {
    public static void main(String[] args) {
        //使用Callable创建线程的步骤
        //1.创建Callable对象
        CallThread callThread = new CallThread();
        //2.创建FutureTask对象,将Callable对象作为参数传入
        FutureTask<Integer> futureTask = new FutureTask<>(callThread);
        //3.创建线程，并将FutureTask对象作为参数传入
        //【提示】FutureTask本质上也是一个Runnable对象
        //所以这里创建线程使用的是 Thread(Runnable task)这个重载方法
        Thread thread = new Thread(futureTask);
        //4.启动线程
        thread.start();

        try {
            //5.获取call()的返回值
            Integer sum = futureTask.get();
            System.out.println("the sum is " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 通过实现Callable接口创建线程
 * 线程需要执行的方法在call()中定义
 */
class CallThread implements Callable<Integer> {
    int sum = 0;
    //线程中需要执行的方法在call()方法中定义
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    }
}
