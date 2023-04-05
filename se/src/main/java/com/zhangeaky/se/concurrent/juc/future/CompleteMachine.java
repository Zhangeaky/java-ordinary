package com.zhangeaky.se.concurrent.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteMachine {

    public static void main(String[] args) {
        CompletableFuture<Machine> cf =
                CompletableFuture.completedFuture(new Machine(0));

        try {
            Machine machine = cf.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
