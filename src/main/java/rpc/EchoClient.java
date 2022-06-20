package rpc;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap().group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress("127.0.0.1", 12220))
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {

                        ch.pipeline().addLast(new ClientHandler());
                    }
                });


        ChannelFuture connect = bootstrap.connect();



            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            System.out.println("[console] input: " + i);

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(i);
            connect.channel().writeAndFlush(out.toByteArray());

    }
}


class ClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[CLIENT] one connetion get !");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("[CLIENT] received msg: " + msg.toString(CharsetUtil.UTF_8));
    }

    public static void main(String[] args) {
        //System.out.println(UUID.randomUUID().toString().replace('-', '') ;
        //System.out.println(Integer.valueOf(1).hashCode());
    }
}
