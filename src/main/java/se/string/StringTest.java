package se.string;

import com.google.common.base.Charsets;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.Stream;

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
