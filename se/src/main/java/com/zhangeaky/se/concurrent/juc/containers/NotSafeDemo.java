package com.zhangeaky.se.concurrent.juc.containers;

import java.util.ArrayList;

public class NotSafeDemo {

    public static void main(String[] args) {

        ArrayList<Integer> ll = new ArrayList<>();

        new Thread(()->{
            for (int i=0;i<100;i++) {
                ll.add(i);
            }
        }).start();

        new Thread(()->{
            for (int i=0;i<ll.size();i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }).start();

        new Thread(()->{
            for (int i=0;i<ll.size();i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }).start();


        new Thread(()->{
            for (int i=0;i<ll.size();i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }).start();


        while (true);






    }
}
