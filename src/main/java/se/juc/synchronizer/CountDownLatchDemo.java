package se.juc.synchronizer;

import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{

        CountDownLatch latch = new CountDownLatch(5);

        ForkJoinPool pool = new ForkJoinPool(10);

        IntStream.rangeClosed(0, 9 )
                .parallel()
                .forEach((x)->{
                            System.out.println("[log]" + Thread.currentThread().getName());
                            latch.countDown();
                        });

        latch.await();

        System.out.println("[log]" + "main" + Thread.currentThread().getName());
    }
}
