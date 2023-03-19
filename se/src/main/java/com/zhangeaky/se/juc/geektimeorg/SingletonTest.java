package com.zhangeaky.se.juc.geektimeorg;

import com.zhangeaky.se.bean.Person;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class SingletonTest {

    private volatile Person person;

    private Person getInstance() {
        if (person == null) {
            synchronized (SingletonTest.class) {
                if (person == null) {
                    person = new Person();
                }
            }
        }

        return person;
    }

    public static void main(String[] args) throws InterruptedException {

        SingletonTest test = new SingletonTest();

        ForkJoinPool pool = new ForkJoinPool(3);
        pool.execute(test::getInstance);
        pool.execute(test::getInstance);
        pool.execute(test::getInstance);

        pool.awaitTermination(10, TimeUnit.SECONDS);



    }
}
