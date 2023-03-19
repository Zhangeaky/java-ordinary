package com.zhangeaky.se.collections;

import java.util.*;

public class TreeSetDemo {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("12", "12", "12");

        Collection<String> result = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        result.addAll(strings);
        System.out.println(result);



    }

}
