package com.zhangeaky.se.basic;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UrlDemo {

    public static void main(String[] args) throws Exception{

        URL url = new URL("https://global.alipay.com");

        InputStream inputStream = url.openStream();
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name());

        while (scanner.hasNext()) {
            String next = scanner.next();
            System.out.println(next);

        }

        URLConnection connection = url.openConnection();

        connection.connect();
        InputStream result = connection.getInputStream();
        String contentType = connection.getContentType();
        System.out.println(contentType);



        //url.openConnection(Proxy.Type.SOCKS);


    }
}
