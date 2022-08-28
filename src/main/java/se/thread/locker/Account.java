package se.thread.locker;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 活锁
 */
public class Account {

    private int balance;
    private final Lock lock = new ReentrantLock();

    void transfer(Account target, int num) {

        while (true) {
            if (this.lock.tryLock()) {
                try{
                    if (target.lock.tryLock()) {
                        try {
                            this.balance -= num;
                            target.balance += num;
                        } finally {
                            target.lock.unlock();
                        }
                    }
                } finally {
                    this.lock.unlock();
                }
            }
        }
    }//transfer


}

class test {

    private volatile int balance;

    public void buy() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        if (this.balance < 10) {
            this.wait();
            System.out.println(Thread.currentThread().getName() + " 目前余额 " + balance);
            System.out.println("买买买");
            this.balance -= 10;
        }
    }

    public synchronized void topUp() throws InterruptedException {

        while (this.balance < 11) {
            System.out.println(Thread.currentThread().getName() + " 余额不足正在充值 。。。" + " 账户余额 " + balance + "元");
            balance++;
        }

        this.notifyAll();
        this.wait();

    }

    public static void main(String[] args) throws Exception{
        test me = new test();

        Thread thread0 = new Thread(() -> {
            try {
                me.topUp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread0.setName("topup");

        Thread thread1 = new Thread(() -> {
            try {
                me.buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.setName("buy");

        thread0.start();
        thread1.start();

        thread0.join();
        thread1.join();




    }
}
