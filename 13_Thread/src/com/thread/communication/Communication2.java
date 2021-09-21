package com.thread.communication;

/**
 * @author mxs
 * 这里用于模拟顾客消费同时生产者生产商品的过程
 * 需要注意线程安全问题(如：生产者刚生产还没有打印就被消费者拿走，导致输出可能为0)
 * 要求：生产者生产产品大于20则停止生产，直到被消费者购买
 * 当产品为零，消费者停止购买
 */
public class Communication2 {
    public static void main(String[] args) {
        //所有消费者和生产都公用这个锁
        Clerk clerk = new Clerk();
        Customer customer = new Customer(clerk);
        Producer producer = new Producer(clerk);
        customer.setName("消费者1");
        producer.setName("生产者1");
        customer.start();
        producer.start();
    }
}

/**
 * 售货员类
 * 在这个类负责定义售出和生产的方法
 */
class Clerk{
    private int count = 0;
    //所有消费者和生产者都共用该类
    //所以所有线程的锁（同步监视器）都是该类
    public synchronized void product(){
        if (count<20){
            count++;
            System.out.println(Thread.currentThread().getName()+" 生产第" + count + "个产品");
            //由于开始生产产品了可以唤醒被阻塞的消费者西安城
            notify();
        }else {
            try {
                //生产超过20个产品的时候当前进程被阻塞
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void consume(){
        if (count>0){
            System.out.println(Thread.currentThread().getName()+" 消费第" + count + "个产品");
            count--;
            //由于产品被消费了，可以唤醒生产者的进程
            notify();
        }else {
            try {
                //当没有产品的时候将会被阻塞
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true) {
            clerk.product();
        }
    }
}
class Customer extends Thread{
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            clerk.consume();
        }
    }
}
