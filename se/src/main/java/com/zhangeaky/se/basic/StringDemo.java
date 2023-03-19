package com.zhangeaky.se.basic;

public class StringDemo {

    public static void test01() {

        String a = "init";

        String concat = a.concat("-");
        System.out.println("concat: " + concat);
        String one = "one";
        String hello = "one";
        System.out.println("is: " + (one == hello));

        StringBuilder sb = new StringBuilder("one");
        System.out.println("is: " + (sb.equals(one)));

    }

    public static void test02() {

        String  name = "yida";

        String substring = name.substring(2);
        System.out.println("SubString case 1: " + substring);

        String substring1 = name.substring(0, 2);
        System.out.println("SubString case 2: " + substring1);

        CharSequence charSequence = name.subSequence(0, 2);
        System.out.println("charSequence case: " + charSequence + charSequence.getClass());

    }
    public static void main(String[] args) {

        String a = "yida";

        String b = "yida";

        System.out.println(a == b);

        test01();
        test02();

    }
}
