package se.thread.geektimeorg;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class Demo1 {

    int x= 0;
    volatile boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void read() {
        if (v == true) {
            System.out.println("x" + x);
        }
    }

    public static void main(String[] args) {

        Demo1 course = new Demo1();

        ForkJoinPool pool = new ForkJoinPool(3);

        pool.execute(() -> {
            IntStream.rangeClosed(0,1).parallel().forEach((x)->{
                course.read();
            });
        });

        pool.execute(() -> {
            IntStream.rangeClosed(0,1).parallel().forEach((x)->{
                course.writer();
            });
        });


    }
}

class test01{
    int x= 0;
    boolean v = false;

    public void writer() {
        System.out.println("[write]");
        x = 42;
        v = true;
    }

    public void read() {
        System.out.println("[read]");
        if (v == true) {
            System.out.println("x" + x);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        test01 tt = new test01();
        Thread thread1 = new Thread(tt::read);

        Thread thread2 =  new Thread(tt::writer);
        thread2.start();
        thread1.start();
        new Thread(tt::read).start();
        new Thread(tt::read).start();

        new Thread(tt::read).start();

        new Thread(tt::read).start();

        new Thread(tt::read).start();
        new Thread(tt::read).start();
        new Thread(tt::read).start();
        new Thread(tt::read).start();


        thread1.join();
        thread2.join();




    }


}
