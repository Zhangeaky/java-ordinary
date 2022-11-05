package se.juc;

import io.netty.util.concurrent.DefaultThreadFactory;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
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
