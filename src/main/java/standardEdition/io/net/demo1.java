package standardEdition.io.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class demo1 {

    public static void test1() throws IOException {

        ServerSocket socket = new ServerSocket();
        socket.bind(new InetSocketAddress(8080));
        socket.setSoTimeout(1000000);
        Socket accept = socket.accept();
        System.out.println("Address is: " + accept.getInetAddress());
        System.out.println("port is: " + accept.getLocalPort());

    }

    public static void main(String[] args) {
        try {

            test1();


        } catch (Exception t) {
            System.out.println("");
            System.out.println(t.getMessage());
        }

    }



}
