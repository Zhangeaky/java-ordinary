package com.zhangeaky.se.collections.map;

import com.zhangeaky.se.java8.bean.BasketBallPlayer;
import com.zhangeaky.se.java8.stream.StreamDemo3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LinkedHashMapDemo {


    public static void test01() {

        HashMap<Integer, Integer> mm = new LinkedHashMap<>(10, 0.75F, true);

        mm.put(300, 11);
        mm.put(100,12);
        mm.put(500, 23);
        mm.put(200, 22);
        mm.put(101, 22);



        for (Map.Entry element : mm.entrySet()) {

            System.out.println(element.getKey());

        }
        System.out.println("-----------");

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(300, 11);
        hashMap.put(100, 12);
        hashMap.put(500, 23);
        hashMap.put(200, 22);
        hashMap.put(101, 22);

        for (Map.Entry element : hashMap.entrySet()) {

            System.out.println(element.getKey());

        }
    }

    public static void test02() {
        HashMap<String, BasketBallPlayer> playerHashMap = new LinkedHashMap<>(StreamDemo3.players.stream().collect(
                Collectors.toMap(BasketBallPlayer::getName, x->x, (first, second ) -> {
                    return first;
                } )
        ));
        //playerHashMap.

        BasketBallPlayer basketBallPlayer = playerHashMap.get("Harden. J");
        System.out.println(basketBallPlayer);

        for (Map.Entry ele : playerHashMap.entrySet()) {
            System.out.println(ele.getKey());
        }

    }


    public static void main(String[] args) {

        test01();

        //test02();

    }


}
