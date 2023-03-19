package com.zhangeaky.se.io;

import java.io.IOException;

/**
 * @Author: jiegege
 * @Date: 2022/1/25 4:40 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class FormatterDemo {

    public static void main(String[] args) throws IOException {
        System.out.print("");
        System.in.read();

        System.out.println(String.format("nihao %s", "zhangeaky"));
    }
}
