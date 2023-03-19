package com.zhangeaky.se.juc.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    public static void main(String[] args) {

        ReadWriteLock rwl = new ReentrantReadWriteLock();
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        Thread thread = Thread.currentThread();

    }
}
