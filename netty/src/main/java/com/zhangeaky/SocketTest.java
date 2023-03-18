package com.zhangeaky;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.stream.Stream;

public class SocketTest {


    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("www.baidu.com", 80);
        Socket socket = new Socket();

        try {
            socket.connect(address);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            int read = inputStream.read();

            byte[] data = new byte[10];
            int read1 = inputStream.read(data);
            Stream.of(data).forEach(System.out::println);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
