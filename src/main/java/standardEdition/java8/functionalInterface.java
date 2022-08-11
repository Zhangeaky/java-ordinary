package se.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class functionalInterface implements Consumer<String>, Predicate<String>, Function<String, Integer> {


    @Override
    public void accept(String o) {
        System.out.println(o);
    }

    @Override
    public boolean test(String s) {
        return false;
    }

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
