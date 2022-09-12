package se.juc.synchronizer;

import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class SemaphoreDemo {

    static int count;

    static final Semaphore s = new Semaphore(1000);

    static void addOne()  {

        System.out.println("[log] " + Thread.currentThread().getName());

        try {
            s.acquire();
        }catch (Exception e) {
            System.out.println("异常！");
        }

        try {
            count+=1;
        }finally {
            s.release();
        }
    }

    public static void main(String[] args) {

        //Thread tt = new Thread(SemaphoreDemo::addOne);

        IntStream.rangeClosed(0,199)
                .parallel().forEach((x)->{
                    addOne();
                });
        System.out.println(count);



    }
}
