package se.juc.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibonacciDemo {

    static class Fibonacci extends RecursiveTask<Integer> {

        final int n;

        Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {

            if (n <= 1) {
                return n;
            }

            Fibonacci f1 = new Fibonacci(n-1);

            f1.fork();

            Fibonacci f2 = new Fibonacci(n-2);

            return f1.compute() + f2.join();

        }
    }

    public static void main(String[] args) {

        ForkJoinPool fjp = new ForkJoinPool(4);

        Fibonacci fib = new Fibonacci(30);

        Integer invoke = fjp.invoke(fib);
        System.out.println(invoke);

    }

}
