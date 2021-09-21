package com.thread.ticketProblem;

/**
 * 方法2
 * 解决通过继承Thread类
 * 中的线程同步安全问题
 * 同样是通过加锁的方式去解决
 * @author mxs
 */
public class TicketProblem2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}

class Window2 extends Thread {
    //共享数据必须是静态的，否则数据将无法共享
    public static int count = 100;

    @Override
    public void run() {
        //synchronized(){}不能放在while上面，因为会导致某一个线程在while中循环结束才释放线程，无法达到多线程的目的
        while (true) {
            //如果使用继承Thread的方式创建新的线程，锁不能是this，因为每一次创建Window2都会创建一个新的对象
            //但是可以用Window2.class的方式，在内存中只会加载一次这个对象，达到了共享锁
            synchronized (Window2.class) {
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    count--;
                }
                else{
                    break;
                }
            }
        }
    }
}

