package com.zhangeaky.se.io.nettysth;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class ServerDemo {

    public static void main(String[] args) {

        NioEventLoopGroup thread = new NioEventLoopGroup(2);
        NioServerSocketChannel server = new NioServerSocketChannel();
        thread.register(server);
        server.bind(new InetSocketAddress(9090));
        ChannelPipeline serverPipeline = server.pipeline();
        serverPipeline.addLast(new MyHander(new HandlerInitializer(), thread));

    }

    /**
     * 应该是自己实现的， 不应该被设计为共享的
     *
     * 为什么要有
     *
     * 有种过河拆桥的意思
     * 只有在开始的时候会有意义
     * 完成了初始化工作后，就没有意义了。
     *
     */
    @ChannelHandler.Sharable
    static class HandlerInitializer extends ChannelInboundHandlerAdapter{

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf payload = (ByteBuf) msg;
            System.out.println(payload.isReadable());
            CharSequence charSequence = payload.getCharSequence(0, payload.readableBytes(), CharsetUtil.UTF_8);
            System.out.println("Channel: " + ctx.channel() + " " + charSequence.toString());
            ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.heapBuffer();
            byteBuf.writeBytes("收到".getBytes(StandardCharsets.UTF_8));

            ctx.writeAndFlush(byteBuf);
        }
    }

    static class MyHander extends ChannelInboundHandlerAdapter {

        private HandlerInitializer handler;

        private NioEventLoopGroup group;


        public MyHander(HandlerInitializer handler, NioEventLoopGroup group) {
            this.handler = handler;
            this.group = group;
        }

        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("register success ...");
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("read ...");

            SocketChannel socketChannel = (SocketChannel) msg;
            this.group.register(socketChannel);
            socketChannel.pipeline().addLast(this.handler);

        }
    }
}
