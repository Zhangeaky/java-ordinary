package com.zhangeaky.se.concurrent;

import java.io.IOException;
import java.lang.ref.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Local {


    static class M {
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("我被回收");
        }

        @Override
        public String toString() {
            return "M{我是M对象}";
        }
    }

    public static void test_sofaReference() {

        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);

        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());
        //设置虚拟机的参数 调制成堆区内存只有20兆 -Xmx20M
        byte[] data = new byte[1024*1024*10];
        System.gc();
        System.out.println(m.get());
        System.out.println(m);
    }

    public static void test_weakReference() {

        WeakReference<M> wk = new WeakReference<>(new M());
        System.out.println(wk.get());
        System.gc();
        System.out.println(wk.get());

    }

    public static final List<Object> LIST = new LinkedList<>();



    public static void test_phantomReference() {

        ReferenceQueue<Object> QUEUE = new ReferenceQueue<>();

        PhantomReference<M> pr = new PhantomReference<>(new M(), new ReferenceQueue<>());

        System.out.println(pr.get());

        new Thread(() -> {
            while (true) {
                LIST.add(new byte[1024*1024]);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(pr.get());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference<?> poll = QUEUE.poll();
                if (poll != null) {
                    System.out.println(poll + "我被回收了。");
                }
            }
        }).start();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Person {

        String name = "zhangsan";

    }

    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void test_threadLocal() {

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();

        new Thread(() -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tl.set(new Person());

        }).start();





    }

    public static void main(String[] args) throws IOException {

//        M m = new M();
//        m = null;
//        System.gc();
//        System.in.read();

        //test_sofaReference();
        //test_weakReference();
        //test_phantomReference();
        test_threadLocal();

    }

}
