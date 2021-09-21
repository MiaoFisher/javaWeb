package com.thread;

/**
 * 创建线程的第二种方法,实现Runnable接口
 * 用Runnable来设计售票窗口
 * 这种设计方法仍然存在线程安全问题
 * 【重要】开发中优先使用实现Runnable方法创建线程
 * 原因:1.实现的方式没有继承方式的局限性
 *      2.实现的方式更适合处理多个线程共享数据的情况
 * 继承Thread和实现Runnable接口方式创建线程的共同点
 *      都需要重写run（）方法，将线程逻辑在run()方法中声明
 * @author mxs
 */
public class TicketRunnableProblem {
    public static void main(String[] args) {
        Window1 win = new Window1();
        Thread t1 = new Thread(win);
        Thread t2 = new Thread(win);
        Thread t3 = new Thread(win);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

/**
 * 窗口
 */
class Window1 implements Runnable{
    //由于线程公用一个Runnable对象，所以此变量不需要定义为static的
    private int ticketCount = 100;
    @Override
    public void run() {
        while (ticketCount>0){
            System.out.println(Thread.currentThread().getName()+":" + ticketCount);
            ticketCount--;
        }
    }
}
