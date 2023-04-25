package com.zhangeaky.se.concurrent.lock;

import com.zhangeaky.se.concurrent.CommonResource;
import com.zhangeaky.se.gof23.statemachine.State;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    static int a;


    static void incrV1() {
        a++;
    }


    static synchronized void incrV2() {
        a++;
    }

    static Lock mainLock = new ReentrantLock();

    static synchronized void incrV3() {
        mainLock.lock();
        a++;
        mainLock.unlock();
    }


    public static void main(String[] args) throws Exception{

        long l1 = System.currentTimeMillis();
        for (int i=0; i <2000_000; i++) {

            CommonResource.es.execute(new Runnable() {
                @Override
                public void run() {
                    incrV3();
                }
            });
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);

        CommonResource.es.shutdown();
        CommonResource.es.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println(a);
        System.exit(0);

}}
