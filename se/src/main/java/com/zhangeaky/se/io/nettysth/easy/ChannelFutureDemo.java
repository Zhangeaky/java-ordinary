package com.zhangeaky.se.io.nettysth.easy;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import com.zhangeaky.se.io.nettysth.GenericHanlder;

import java.net.InetSocketAddress;

public class ChannelFutureDemo {


    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(new NioEventLoopGroup())
                .remoteAddress(new InetSocketAddress("127.0.0.1", 12220))
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new GenericHanlder());
                    }
                });

        bootstrap.connect().addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                System.out.println(future.get());
            }
        });

        System.out.println("---");
    }
}
