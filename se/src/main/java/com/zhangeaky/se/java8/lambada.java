package com.zhangeaky.se.java8;

import java.util.function.Function;

/**
 * @Author: jiegege
 * @Date: 2022/1/18 5:38 上午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */


@FunctionalInterface
interface person{
    void say(String sentence);
}


public class lambada {



    static void makePersonSaySomething(person person) {
    }

    public void fun() {
        System.out.println();
    }


    public static void main(String[] args) {
        Function<Integer, String> f = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {

                switch (integer) {
                    case 1:
                        return "one";
                    case 2:
                        return "two";
                    case 3:
                        return "three";
                    default:
                        return "haha";
                }

            }

        };

        System.out.println(f.apply(3));

    }

}
