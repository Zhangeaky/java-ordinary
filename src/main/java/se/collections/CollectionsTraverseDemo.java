package se.collections;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

public class CollectionsTraverseDemo {

    private static Map<String, String> map= ImmutableMap.of("zhangyikai", "25", "laoge", "29",
            "laomei", "21");

    private static HashMap<String, String> names = new HashMap<>();

    static {
        System.out.println(map.getClass().getCanonicalName());

        names.put("a", "a");
        names.put("b", "b");
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
    }

    public static void main(String[] args) {

       // traverseMap();

        Map<String, String> hashMap = new HashMap<>();

        System.out.println(names.entrySet().getClass().getCanonicalName());


        //System.out.println(hashMap.get(""));
    }





}
