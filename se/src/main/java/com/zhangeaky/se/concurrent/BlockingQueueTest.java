package com.zhangeaky.se.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {


    public static void main(String[] args) {

        LinkedBlockingQueue<String> nameList = new LinkedBlockingQueue<>(3);
        System.out.println("begin ...");
        nameList.offer("yida");
        nameList.offer("tongshao");
        nameList.offer("like");
        nameList.offer("hahah");
        System.out.println("end ...");

    }
}
