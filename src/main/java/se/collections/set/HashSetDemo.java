package se.collections.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    private static Set<Integer> numbers = new HashSet<>(10);

    public static void main(String[] args) {



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


}
