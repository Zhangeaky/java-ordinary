package com.zhangeaky.se.concurrent.juc.locker.account;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Account {

    public Account(Double balance) {
        this.balance = balance;
    }

    private Double balance;

    public synchronized void transfer(Account account, Double money) {

        if (balance > money) {
            balance = balance - money;
            account.balance += money;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {

        Account A = new Account(200D);
        Account B = new Account(200D);
        Account C = new Account(200D);

        ForkJoinPool pool = new ForkJoinPool(10);
        pool.execute(()->{
            A.transfer(B, 100D);});

        pool.execute(()->{
            B.transfer(C, 100D);
        });

        pool.awaitTermination(100, TimeUnit.MICROSECONDS);


        Stream.of(A, B, C).forEach(System.out::println);




    }


}
