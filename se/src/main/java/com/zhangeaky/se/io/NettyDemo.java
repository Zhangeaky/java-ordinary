package com.zhangeaky.se.io;

import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyDemo {

    static class MyHandler implements ChannelInboundHandler {

        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("active ...");
        }

        @Override
        public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {

        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        }

        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        }

        @Override
        public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {

        }

        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        }

        @Override
        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        }
    }

    public static void main(String[] args) {

        try {

            NioSocketChannel socket = new NioSocketChannel();

            NioEventLoopGroup group = new NioEventLoopGroup(1);

            ChannelFuture register = group.register(socket);
            ChannelPipeline pipeline = socket.pipeline();
            pipeline.addLast();


        } catch (Throwable t) {

        }




    }
}
