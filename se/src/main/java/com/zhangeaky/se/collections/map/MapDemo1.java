package com.zhangeaky.se.collections.map;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {

    public static void test01() {
        try {
            Map<String, String> ren = new HashMap<>(1);
            ren.put("name", "yida");
            ren.put("id", "328153");
            ren.put("is", "328153");
            ren.put("ig", "328153");
            Method capacity = ren.getClass().getDeclaredMethod("capacity");
            capacity.setAccessible(true);
            Object invoke = capacity.invoke(ren);
            System.out.println("capacity: " + invoke);

            System.out.println(ren.size());
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     *  显示指定和初始化HashMap的capacity
     */
    public static void test_02() {

        Map<String, String> mappings = new HashMap<>(3);
        Class<? extends Map> mapzz = mappings.getClass();

        try {
            mapzz.getDeclaredField("capacity");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void temp() {
        Object a = new String("nihao");
        System.out.println("tepm: " + a.hashCode());
        Object aa = new Object();
        System.out.println(aa.hashCode());
    }


    public static void main(String[] args) {

      test01();
      temp();








    }
}
