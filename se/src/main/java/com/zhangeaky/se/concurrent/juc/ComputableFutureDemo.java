package com.zhangeaky.se.concurrent.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class ComputableFutureDemo {

    public static void test01() {

        List<String> bizInst = new ArrayList<>();
        bizInst.add("STONE");
        bizInst.add("MP");
        bizInst.add("13");

        List<String> results = new ArrayList<>();

        List<CompletableFuture> futures = new ArrayList<>();

        long l = System.currentTimeMillis();
        bizInst.stream().forEach(biz ->{

            futures.add(

               CompletableFuture.supplyAsync(() -> {
                    try {
                        int i = new Random().nextInt(10);
                        System.out.println("睡眠： " + i);
                        Thread.sleep(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "业务机构 " + biz;
                }).thenAcceptAsync(result -> {
                   results.add(result);
               })

            );

        });

        futures.parallelStream().forEach(CompletableFuture::join);
        long l1 = System.currentTimeMillis();
        System.out.println("话费时间： " + (l1 - l));



        System.out.println(results);
    }


    public static void main(String[] args) {
        test01();

    }

}
