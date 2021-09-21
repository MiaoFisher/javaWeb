package com.thread.ticketProblem;

/**
 * 通过同步方法来解决线程安全问题(实现Runnable接口的线程)
 * @author mxs
 */
public class TicketProblem3 {
    public static void main(String[] args) {
        Window3 window3 = new Window3();
        Thread t1 = new Thread(window3);
        Thread t2 = new Thread(window3);
        Thread t3 = new Thread(window3);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Window3 implements Runnable{
    private int count = 1000;
    @Override
    public void run() {
        while (true){
            show();
            if (count==0){
                break;
            }
        }
    }
    //在方法中添加同步
    //默认的锁就是this
    public synchronized void show(){
        if (count>0){
            System.out.println(Thread.currentThread().getName()+":"+count);
            count--;
        }
    }
}
