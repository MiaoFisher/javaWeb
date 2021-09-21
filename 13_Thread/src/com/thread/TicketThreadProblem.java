package com.thread;

/**
 * 在这里模拟火车站卖票的问题（三个窗口同事售卖票的过程）
 *但是这种方法还是有一定的问题，可能造成某一张票被多个线程同事抢占的问题
 * @author mxs
 */
public class TicketThreadProblem {
    public static void main(String[] args) {
        Window window1 = new Window("窗口1");
        Window window2 = new Window("窗口2");
        Window window3 = new Window("窗口3");
        window1.start();
        window2.start();
        window3.start();
    }
}

/**
 * 售票窗口
 */
class Window extends Thread {
    //创建一个构造方法设置线程的名字
    public Window(String threadName){
        this.setName(threadName);
    }
    //在这里设定票的总数
    //【强制】如果需要多个线程共享同一个count，就必须将这个变量设为static（静态的）,否则每次创建一个新的线程都会创建一个新的变量
    private static int count = 100;
    //模拟售票的过程
    @Override
    public void run() {
        while (true) {
            if (count > 0) {
                System.out.println(getName() + ":" + count);
                count--;
            }else {
                break;
            }
        }
    }
}