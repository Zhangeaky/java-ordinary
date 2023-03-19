package com.zhangeaky.se.annotation.spring;



public class Test {

    @Try
    static class demo {

    }

    public static void main(String[] args) {
        demo demo = new demo();
        System.out.println(demo.getClass().getAnnotation(Try.class));
    }
}
