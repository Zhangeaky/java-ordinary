package com.zhangeaky.se.io.nettysth;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.buffer.UnpooledDirectByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.nio.charset.StandardCharsets;

public class NettyStyleClient {

    public static void main(String[] args) throws InterruptedException {

        Bootstrap bs = new Bootstrap();

        NioEventLoopGroup group = new NioEventLoopGroup();

        Bootstrap handler = bs.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                        ch.pipeline().addLast(new MyInhandler());

                    }
                });

        ChannelFuture connect = handler.connect("localhost", 8888);
        ByteBuf content = UnpooledByteBufAllocator.DEFAULT.buffer(1024);
        content.writeBytes("hello".getBytes(StandardCharsets.UTF_8));
        connect.channel().writeAndFlush(content);
        System.out.println(bs.equals(handler));


    }


    static class MyInhandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println(" read ...");

            ByteBuf message = (ByteBuf) msg;

            CharSequence charSequence = message.getCharSequence(0, message.readableBytes(), CharsetUtil.UTF_8);
            System.out.println(charSequence);

        }
    }
}
