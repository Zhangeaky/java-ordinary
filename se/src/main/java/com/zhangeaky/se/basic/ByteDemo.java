package com.zhangeaky.se.basic;
import java.util.Arrays;
import java.util.stream.Stream;

public class ByteDemo {

    static protected void test_package() {}

    public static void main(String[] args) {

        Byte[] bytes = new Byte[]{1,2,3,4,'a','#', '1' };

        System.out.println(Arrays.toString("zhangyikai".getBytes()));

        Stream.of(bytes).forEach(System.out::println);

    }
}

class PackageInner{
    static void say() {

    }
}
