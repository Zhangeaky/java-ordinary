package se.collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetDemo {

    private static Set<Integer> numbers = new HashSet<>(10);

    public static void test_api() {

        numbers.add(1);
        numbers.add(5);
        numbers.add(3);
        numbers.add(1);
        numbers.add(5);
        numbers.add(3);
        numbers.add(1);
        numbers.add(5);
        numbers.add(3);
        numbers.add(1);
        numbers.add(5);
        numbers.add(3);

        numbers.stream().forEach(System.out::println);


    }

    public static void  test_addAll() {
        List<String> mem = new ArrayList<>();
        mem.add("A");
        mem.add("A");
        System.out.println("list: " + mem);
        Set<String> set = new HashSet<>();
        set.addAll(mem);
        System.out.println("set: " + set);


    }


    public static void test_api1() {
        int i = 10;
        while (i > 0) {
            i--;
            numbers.add(i);

        }
        numbers.add(1000);
        numbers.add(100);
        numbers.add(99);
        numbers.forEach(System.out::println);
    }

    public static void main(String[] args) {
            //test_api();
        test_addAll();



    }
}
