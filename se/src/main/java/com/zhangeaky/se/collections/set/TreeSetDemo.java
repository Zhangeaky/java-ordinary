package com.zhangeaky.se.collections.set;

import com.zhangeaky.se.java8.bean.BasketBallPlayer;
import com.zhangeaky.se.java8.stream.StreamDemo3;

import java.util.*;

import static com.zhangeaky.se.java8.stream.StreamDemo3.players;

public class TreeSetDemo {



    public static void test01() {

        Set<Integer> num = new TreeSet<>();
        num.add(100);
        num.add(10);
        num.add(2);
        num.add(50);
        num.forEach(System.out::println);

        Set<Integer> nums = new LinkedHashSet<>();
        nums.add(11);
        nums.add(11);
        nums.add(11);
        nums.forEach(System.out::println);
    }

    public static void  test02() {

        Set<BasketBallPlayer> pp = new TreeSet<>();

        List<BasketBallPlayer> ll = new ArrayList<>();
        ll.add(players.get(0));
        ll.add(players.get(5));
        ll.add(players.get(3));

        pp.addAll(ll);
        System.out.println(pp);

        List<BasketBallPlayer> players = StreamDemo3.players;
        ll.sort(Comparator.comparing(x->-x.getPts()));
        System.out.println(ll);

    }


    public static void main(String[] args) {

        //test01();
        test02();

    }
}
