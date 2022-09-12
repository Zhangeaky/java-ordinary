package se.juc.thread;

public class Boom {

    public synchronized static void dead() {
        while (true);
    }

    public static void main(String[] args) {


        while (true) {
            new Thread(()->{
                System.out.println("name: " + Thread.currentThread().getName());
                dead();
            }).start();
        }
    }
}
