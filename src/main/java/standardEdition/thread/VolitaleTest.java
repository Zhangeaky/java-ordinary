package se.thread;

import java.io.IOException;

public class VolitaleTest {
    public static volatile int race = 0;
    public static synchronized/*去掉*/ void  increase() {
        race++;
    }
    public static final int THREAD_COUNT = 25;

    public static void main(String[] args) throws IOException {

        Thread[] threads = new Thread[THREAD_COUNT];

    for (int i=0; i < THREAD_COUNT; i++) {
        threads[i] = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i < 10000; i++) {
                    System.out.println("add ...");
                    increase();
                }
            }
        });
        threads[i].start();
    }


//    while (Thread.activeCount() > 1) {
//        Thread.yield();
//    }
        System.in.read();

        System.out.println(race);

    }


}
