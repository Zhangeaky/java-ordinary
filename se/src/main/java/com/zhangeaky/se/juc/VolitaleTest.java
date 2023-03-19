package com.zhangeaky.se.juc;

import java.io.IOException;
import java.util.Optional;

public class VolitaleTest {
    public static  int race = 0;
    public static /*去掉*/ void  increase() {
        race++;
    }
    public static final int THREAD_COUNT = 8;

    public static void main(String[] args) throws IOException, InterruptedException {

        Thread[] threads = new Thread[THREAD_COUNT];

    for (int i=0; i < THREAD_COUNT; i++) {
        threads[i] = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i < 100000000; i++) {
                    System.out.println("add ...");
                    increase();
                }
            }
        });
        threads[i].start();
    }


    for (int i=0; i < THREAD_COUNT; i++) {
        threads[i].join();
    }


//    while (Thread.activeCount() > 1) {
//        Thread.yield();
//    }

        System.out.println(race);

    }


}

class test {


    private synchronized void see(){
        System.out.println("see");
        try {
            System.in.read();

        }catch (Exception e) {

        }
    }

    private synchronized void eat() {
        System.out.println("eat");
    }

    public static void main(String[] args) {
        test tt = new test();

        tt.eat();
        tt.see();
        tt.eat();
    }





}

class test_03 {
    public static void main(String[] args) {

        Optional.ofNullable(null).orElseThrow(()->{
            return new RuntimeException();
        });





    }
}
