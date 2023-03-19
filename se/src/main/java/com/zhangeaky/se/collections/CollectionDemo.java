package com.zhangeaky.se.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionDemo {
    public static void main(String[] args) {

        List<String> ll = new ArrayList<>();
        ll.add("1");
        ll.add("2");
        ll.add("3");
        ll.add("4");
        ll.add("5");

        List<String> pp = new ArrayList<>();
        pp.add("a");
        pp.add("b");

        System.out.println(ll);
        ll.addAll(1, pp);
        System.out.println(ll);




    }
}
