package com.zhangeaky.se.juc.containers.nosafecase;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import static com.zhangeaky.se.java8.stream.StreamDemo3.players;
public class Demo1 {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(100);
        IntStream.rangeClosed(0,99)
                .parallel()
                .forEach((x)->{
                    latch.countDown();
                    names.add(players.get(ThreadLocalRandom.current().nextInt(10)).getName());
                });
        try {
            latch.await();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("go!");
        String format = String.format("size %d", names.size());
        System.out.println(format);
        System.out.println(names);
    }

}
