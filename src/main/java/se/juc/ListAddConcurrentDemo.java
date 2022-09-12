package se.juc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 *  收集一下 线程不安全的集合在 并发的场景下会出现什么问题 ？
 *
 */
public class ListAddConcurrentDemo {

    private  static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        list = new LinkedList<>();

        IntStream.rangeClosed(0, 999)
                .parallel()
                .forEach((x)->{
                    list.add(x);
                });

        System.out.println("[size]: " + list.size());
    }

}
