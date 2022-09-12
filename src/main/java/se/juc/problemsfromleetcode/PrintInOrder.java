package se.juc.problemsfromleetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintInOrder {

    private final Foo foo = new Foo();

    class Foo {

        public Foo() {}

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            printSecond.run();
        }

        public void third(Runnable printThird) throws InterruptedException {
            printThird.run();
        }
    }

    private void doTask(Map<Integer, Boolean> map, Integer x) {

        synchronized (Foo.class) {

            if (!map.get(--x)) {

                // 不满足条件

            } else if (Objects.isNull(map.get(--x))) {

               // foo.

            }

        }



    }

    public static void test(Integer[] input) {

        Map<Integer, Boolean> flag = new HashMap<>(Stream.of(input).collect(Collectors.toMap(x -> x, x -> false)));
        System.out.println(flag);


    }

    public static void main(String[] args) {
        test(new Integer[]{1,2,3,});
    }




}


