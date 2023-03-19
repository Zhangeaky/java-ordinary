package com.zhangeaky.rpc;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("[SERVER] is on ...");

        MyHander hander = new MyHander();

        NioEventLoopGroup group = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group)
                .localAddress(new InetSocketAddress(12220))
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new MyDecoder());
                        ch.pipeline().addLast(hander);
                    }
                });

        ChannelFuture future = bootstrap.bind().sync();

        future.channel().closeFuture().sync();

        //System.out.println("...");

    }
}

@ChannelHandler.Sharable
class MyHander extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[server] get one conneciton.");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println(msg.getClass());
        Integer content = (Integer) msg;
        System.out.println("[server]: msg is: " + msg);


    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }
}
