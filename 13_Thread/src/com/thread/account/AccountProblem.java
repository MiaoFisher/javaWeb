package com.thread.account;

/**
 * 模拟两个用户同时向同一个账户存钱存在的安全线程问题
 * 以及解决方法
 */

public class AccountProblem {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();
    }
}

/**
 * 账户类
 */
class Account {
    private float balance;

    public Account(float balance) throws InterruptedException {
        //在这里增加睡眠时间，模拟可能出现的线程安全问题
        Thread.sleep(1000);
        this.balance = balance;
    }

    /**
     * 存钱的方法
     * 在这里可以直接使用synchronized的原因是，多个储户同时使用同一个账户，所以this都是同一个账户
     * @param money
     */
    public synchronized void deposit(float money) {
        balance += money;
    }
    public float getBalance(){
        return this.balance;
    }
}
class Customer extends Thread{
    private Account account;
    public Customer(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
            System.out.println(Thread.currentThread().getName()+":"+account.getBalance());
        }
    }
}
