package se.collections;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CollectionsTraverseDemo {

    private static Map<String, String> map= ImmutableMap.of("zhangyikai", "25", "laoge", "29",
            "laomei", "21");

    private static HashMap<String, String> names = new HashMap<>();

    static {
        System.out.println(map.getClass().getCanonicalName());

        names.put("a", "a");
        names.put("b", "b");
    }

    public static void showSet() {

        Set<String> strings = map.keySet();
        Set<Map.Entry<String, String>> entries = map.entrySet();



    }

    /**
     * Entry HashMap中是 Nodes实现
     *
     * KeySet 以map的不重复的key作为set
     *
     */
    private static void traverseMap() {

        for (Map.Entry<String, String>  ele: map.entrySet()) {
            System.out.print("key is " + ele.getKey() + " ");
            System.out.println("value is " + ele.getValue());
        }

        System.out.println("---");

        for (String key:map.keySet()) {
            System.out.println("Key is: " + key);
        }


        System.out.println("-----map.entrySet().iterator 遍历------");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            String value = next.getValue();
            String key = next.getKey();
            System.out.println("[key]: " + key + "[value]: " + value);
        }


    }

    public static void main(String[] args) {

        traverseMap();

        Map<String, String> hashMap = new HashMap<>();

        Set<Map.Entry<String, String>> entries = hashMap.entrySet();


        //System.out.println(names.entrySet().getClass().getCanonicalName());


        //System.out.println(hashMap.get(""));
    }





}
