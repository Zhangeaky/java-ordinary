package com.zhangeaky.se.io.nettysth;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

public class NettyStyleServer {

    public static void main(String[] args) throws InterruptedException {

        NioEventLoopGroup group = new NioEventLoopGroup();

        ServerBootstrap bs = new ServerBootstrap();
        bs.group(group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new MyInHandler());
                    }
                })
                .bind(new InetSocketAddress(7777)).sync();


    }


}
class MyInHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf content = (ByteBuf) msg;
        CharSequence charSequence = content.getCharSequence(0, content.readableBytes(), CharsetUtil.UTF_8);
        ctx.writeAndFlush(charSequence);

    }
}

class temp {
    public static void main(String[] args) throws InterruptedException {

        NioEventLoopGroup group = new NioEventLoopGroup(1);
        ServerBootstrap bs = new ServerBootstrap();
        ChannelFuture bind = bs.group(group, group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new MyInHandler());
                    }
                })
                .bind(new InetSocketAddress("localhost", 9090));

        bind.sync().channel().closeFuture().sync();

    }
}

class test1 {

    static class testHandler extends ChannelInboundHandlerAdapter {


        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {

            System.out.println("new connect ...");

        }

    }

    public static void main(String[] args) {

        Bootstrap bs = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        bs.group(group)
                .channel(NioServerSocketChannel.class)
                .handler(new testHandler())
                .connect(new InetSocketAddress(9888));

        System.out.println("over");

    }

}
