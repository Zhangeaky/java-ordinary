package se.io.net.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Set;

public class SimpleServer {


    public static void main(String[] args) throws Exception{

        try{

            ServerSocketChannel server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(9090));
            server.configureBlocking(false);

            Set<SocketChannel> clients = new HashSet<>();

            while (true) {

                SocketChannel client = server.accept();
                if (client != null) {
                    System.out.println("remote address" + client.getRemoteAddress());
                    client.configureBlocking(false);
                    clients.add(client);
                }


                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

                for (SocketChannel element:clients) {
                    //System.out.println("文件描述符的数量是: " + clients.size());

                    int read = element.read(byteBuffer);

                    if ( read > 0) {

                        byteBuffer.flip();
                        System.out.println("read: " + read);
                        byte[] aaa = new byte[byteBuffer.limit()];
                        byteBuffer.get(aaa);
                        String b = new String(aaa);
                        System.out.println("content: " + b );
                        byteBuffer.clear();

                    }



                }



            }

        }catch (IOException e) {

        }



    }

}
