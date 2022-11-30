package se.collections.map;

import se.java8.bean.BasketBallPlayer;
import static se.java8.stream.StreamDemo3.players;
import java.util.*;

public class TreeMapDemo {

    public static TreeMap<Integer, String> staffs = new TreeMap<>();
    static {
        staffs.put(51, "yida");
        staffs.put(12, "霍华德");
        staffs.put(37, "阿泰湖人");
        staffs.put(84, "哈哈哈");
        staffs.put(10, "埃里克戈登");
        staffs.put(8, "杰梅因泰勒");
        staffs.put(5, "凯文加内特");
        staffs.put(0, "韦斯特布鲁克");
    }

    public static void test_sortedMap() {
        //根据key的hashCode进行排序
        System.out.println("全量打印： " + staffs);
        //根据key的范围选出部分键值对map
        SortedMap<Integer, String> subMap = staffs.subMap(20, 100);
        System.out.println("范围打印： " + subMap);
        subMap.put(55, "木托木钵");
        //subMap.put(13, "harden");
        System.out.println("全量打印： " + staffs);

        SortedMap<Integer, String> headMap = staffs.headMap(10);
        System.out.println("headMap 打印: " + headMap);

        SortedMap<Integer, String> tailMap = staffs.tailMap(10);
        System.out.println(tailMap);
        System.out.println("tailMap 打印: " + tailMap);

        System.out.println("firstKey(): " + staffs.firstKey());
        System.out.println("lastKey(): " + staffs.lastKey());

    }

    public static void test_navigableMap() {
        Map.Entry<Integer, String> integerStringEntry = staffs.lowerEntry(56);
        System.out.println("lowerEntry打印: " + integerStringEntry);
        Integer integer = staffs.lowerKey(56);
        System.out.println("lowerKey打印: " + integer);
        Map.Entry<Integer, String> integerStringEntry1 = staffs.floorEntry(56);
        System.out.println("floorEntry打印: " + integerStringEntry1);
        Map.Entry<Integer, String> integerStringEntry2 = staffs.ceilingEntry(0);
        System.out.println("ceilingEntry打印: " + integerStringEntry2);
        Map.Entry<Integer, String> integerStringEntry3 = staffs.higherEntry(0);
        System.out.println("higherEntry打印: " + integerStringEntry3);
        NavigableMap<Integer, String> integerStringNavigableMap = staffs.descendingMap();
        System.out.println("descendingMap 打印: " + integerStringNavigableMap);
        NavigableSet<Integer> integers = staffs.navigableKeySet();
        System.out.println(integers);
        System.out.println(staffs.descendingKeySet());
    }

    public static void init_treeMap_test() {

        TreeMap<BasketBallPlayer, String> map = new TreeMap<>(new Comparator<BasketBallPlayer>() {
            @Override
            public int compare(BasketBallPlayer o1, BasketBallPlayer o2) {
                if (o1.getPts()-o2.getPts() > 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        map.put(players.get(1), players.get(1).getName());
        map.put(players.get(3), players.get(3).getName());
        map.put(players.get(5), players.get(5).getName());
        map.put(players.get(7), players.get(7).getName());

        System.out.println(map);
    }

    public static void main(String[] args) {
        //test_sortedMap();
        //test_navigableMap();
        init_treeMap_test();
    }
}
