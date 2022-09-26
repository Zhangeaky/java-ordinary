package se.juc;

import java.util.concurrent.CompletableFuture;

public class ComputableFutureDemo {


    public static void main(String[] args) {

        CompletableFuture<Void> f1 =
        CompletableFuture.runAsync(()->{

        });

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {


            return "龙井";
        });




    }

}
