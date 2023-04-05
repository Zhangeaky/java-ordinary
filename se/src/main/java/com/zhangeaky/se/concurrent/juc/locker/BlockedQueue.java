package com.zhangeaky.se.concurrent.juc.locker;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueue<T> {

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    Queue<T> queue = new ArrayDeque<>(10);

    void enq(T input) {

        Thread.currentThread().interrupt();
        lock.lock();
        try {

            while ( queue.size() == 10 ) {
                notFull.await();
            }

            queue.add(input);
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void deq() {

        lock.lock();

        try {

            while (queue.isEmpty()) {
                notEmpty.await();
            }
            queue.poll();
            notFull.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }



}
