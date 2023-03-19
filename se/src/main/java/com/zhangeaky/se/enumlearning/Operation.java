package com.zhangeaky.se.enumlearning;

import java.util.Arrays;

public enum Operation implements MathOperation{

    ADD("+", "加法") {
        @Override
        public int add(int a, int b) {
            return a+b;
        }
    }
    ;


    private String symbol;
    private String name;

    Operation(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

}

class test{
    public static void main(String[] args) {

        Operation add = Operation.ADD;
        System.out.println(Arrays.toString(add.getClass().getDeclaredMethods()));
    }
}
