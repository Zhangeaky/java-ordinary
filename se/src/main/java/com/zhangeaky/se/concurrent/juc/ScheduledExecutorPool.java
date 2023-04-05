package com.zhangeaky.se.concurrent.juc;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorPool {

    public static void main(String[] args) throws Exception{

        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(5);

        pool.scheduleAtFixedRate(()->{
            System.out.println("Hello world");
        }, 5, 5, TimeUnit.SECONDS);


        Thread.currentThread().join();


    }
}
