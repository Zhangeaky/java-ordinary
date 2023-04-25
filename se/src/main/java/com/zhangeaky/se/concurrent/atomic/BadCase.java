package com.zhangeaky.se.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BadCase {

    public int count;

    public void incr() {
        count++;
    }

    public static void main(String[] args) throws Exception{

        BadCase bc = new BadCase();

        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i=0; i<100; i++) {
            pool.execute(bc::incr);
        }
        //Thread.currentThread().join();

        System.out.println(bc.count);

    }

}
