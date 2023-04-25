package com.zhangeaky.se.concurrent.ThreadPool;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.*;

public class ThreadPool {



    public static void main(String[] args) {

        ThreadPoolExecutor es = new ThreadPoolExecutor(10, 20, 20,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(2),  Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy() );

        for (int i=0; i <2000; i++) {

            es.execute(new Runnable() {
                @Override
                public void run() {


                    System.out.println("start: task" + Thread.currentThread().getName());
                    int count=0;
                    while (count < 2_000_000) {
                        count++;
                    }
                    throw new RuntimeException();

                }
            });

        }








    }

}
