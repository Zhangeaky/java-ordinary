package com.zhangeaky.se.string;

import com.google.common.base.Charsets;

public class StringTest {
    public static void showBytes(byte[] bytes) {
        for (int i=0; i< bytes.length; i++) {
            System.out.println(bytes[i]);
        }
    }

    public static void main(String[] args) {

        String chinese = "我";
        byte[] bytes = chinese.getBytes(Charsets.UTF_8);
        showBytes(bytes);

    }
}
