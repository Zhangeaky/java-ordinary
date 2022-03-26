package JVM.classLoader.initialization;

import java.io.IOException;

/**
 * @Author: jiegege
 * @Date: 2022/1/5 9:03 下午
 * @address: hangzhou
 * @description: 在多线程的情况下，多个线程对同一个类进行了引用，该类的类加载过程只会执行一次。
 * @Version 1.0
 */

class logger {
    //只会被执行一次
    static {
        System.out.println("class logger is loading at initializing phrase ... in " + Thread.currentThread().getName());
    }
    static  String NAME = "log4j";
}


public class MultiThreadClassLoad {

    static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "is using " + logger.NAME);
        }
    }

    public static void main(String[] args) throws IOException {

//        Thread t = new Thread(new MyThread());
        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread()).start();
        }

        System.in.read();

    }
}
