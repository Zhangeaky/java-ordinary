package com.zhangeaky.se.concurrent.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CreateThread {

    static class MyNewThread extends Thread {

        @Override
        public void run() {
            System.out.println("使用继承的方式创建新的线程。" + Thread.currentThread().getName());
        }
    }

    public static void wayOne() {

        Thread instance = new MyNewThread();
        instance.start();
        System.out.println("结束" + Thread.currentThread().getName());

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void wayTwo() {

        Thread myThread = new Thread(() -> {
            System.out.println("使用runnable创建线程");
        });

    }

    public static void wayThree() {

        FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {

                return null;
            }
        });

        Thread myThread = new Thread(ft);

    }

    public static void main(String[] args) {
        wayOne();
    }



}
