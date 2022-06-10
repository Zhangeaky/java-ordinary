package se.util;

import java.util.Enumeration;

/**
 * @Author: jiegege
 * @Date: 2022/1/26 11:57 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class StringDemo {

    public static void main(String[] args) {

        String name = "zhangeaky";

        String concat = name.concat(".class");

        System.out.println(concat);

        Enumeration<?> enumeration = System.getProperties().propertyNames();

        String property = System.getProperty("user.dir");
        System.out.println(property);

        //Class.forName()


    }
}
