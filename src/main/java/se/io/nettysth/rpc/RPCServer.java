package se.io.nettysth.rpc;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import se.io.nettysth.GenericHanlder;

public class RPCServer {

    public static void main(String[] args) {

        ServerBootstrap bs = new ServerBootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bs.group(group)
                .channel(ServerSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new GenericHanlder());
                    }
                }).bind(12220);

        //

    }
}
