package se.juc.locker.dubbo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DubboDemo {

    private final Lock lock = new ReentrantLock();

    public synchronized static void work(int i) {

        try {
            System.out.println("[ ]" + Thread.currentThread().getName());
            if (i > 0 ) {
                DubboDemo.class.wait();
                System.out.println("dfjoidfdfdf");
            }

            DubboDemo.class.notifyAll();

        } catch (Exception e) {

        }

    }



    public static void main(String[] args) throws Exception{

        new Thread(()-> work(10)).start();
        Thread.sleep(4000);
        new Thread(()-> work(-1)).start();

        while (true);


    }
}
