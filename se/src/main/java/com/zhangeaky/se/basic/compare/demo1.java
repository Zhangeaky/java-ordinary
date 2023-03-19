package com.zhangeaky.se.basic.compare;

import com.zhangeaky.se.bean.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class demo1 {

    public static void test01() {

        List<Order> list = new ArrayList<>();
        list.add(new Order(UUID.randomUUID().toString(), Order.Status.INIT.name(), 1));
        list.add(new Order(UUID.randomUUID().toString(), Order.Status.SUCCESS.name(), 3));
        list.add(new Order(UUID.randomUUID().toString(), Order.Status.PROCESSING.name(), 4));
        list.add(new Order(UUID.randomUUID().toString(), Order.Status.SUCCESS.name(), 5));
        list.add(new Order(UUID.randomUUID().toString(), Order.Status.SUCCESS.name(), 6));
        list.add(new Order(UUID.randomUUID().toString(), Order.Status.SUCCESS.name(), 6));


        list.forEach(System.out::println);
        System.out.println("=====排序后====");
        list.stream().sorted().forEach(System.out::println);

    }

    public static void test_comparator() {

    }

    public static void main(String[] args) {

        test01();

    }
}
