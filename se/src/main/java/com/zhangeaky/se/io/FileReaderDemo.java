package com.zhangeaky.se.io;

import java.io.*;

/**
 * @Author: jiegege
 * @Date: 2022/1/25 4:56 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class FileReaderDemo {

    static void getEncoding(FileReader reader) {

        String encoding = reader.getEncoding();
        System.out.println(encoding);

    }

    public static void main(String[] args) throws IOException {

        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(new File("zhangeaky.txt")));
        outputStream.writeChars("zhangeaky");
        getEncoding(new FileReader("zhangeaky.txt") );

        //System.in.read()

    }
}
