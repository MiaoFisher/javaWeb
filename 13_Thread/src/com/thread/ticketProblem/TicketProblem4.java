package com.thread.ticketProblem;

/**
 * 同步方法解决线程安全问题（继承Thread方法的线程）
 * @author mxs
 */
public class TicketProblem4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
class Window4 extends Thread{
    public static int count = 1000;
    @Override
    public void run() {
        while (true){
            show();
        }
    }
    public static synchronized void show(){
        if (count>0){
            System.out.println(Thread.currentThread().getName()+":"+count);
            count--;
        }
    }
}

