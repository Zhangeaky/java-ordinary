package com.zhangeaky.se.juc.geektimeorg;

import java.util.concurrent.ForkJoinPool;

/**
 * @description 原子性的学习
 *
 */
public class Demo2 {



}

class test2_1 {

    long value = 0L;

    synchronized long get() {
        return value;
    }

    synchronized void add() {
        value += 1;
    }

    public static void main(String[] args) {

        test2_1 tt = new test2_1();

//        IntStream.rangeClosed(1, 100000000).parallel().forEach(x->{
//            tt.add();
//        });

        ForkJoinPool pool = new ForkJoinPool(1000);
        for (int i=1000;i>0;i--) {
            pool.execute(tt::add);
        }


        System.out.println(tt.get());


    }
}


