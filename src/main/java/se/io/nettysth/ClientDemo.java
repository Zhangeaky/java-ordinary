package se.io.nettysth;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class ClientDemo {

    public static void main(String[] args) throws InterruptedException {

//        NioEventLoopGroup group = new NioEventLoopGroup(3);
//
//        NioSocketChannel clientSocket = new NioSocketChannel();
//        group.register(clientSocket);
//
//        // 任务链
////        ChannelPipeline pipeline = clientSocket.pipeline();
////
////        pipeline.addLast(new Mychan)
//        ChannelFuture connectResult = clientSocket.connect(new InetSocketAddress("localhost", 9090));
//        connectResult.sync();
//
//        ByteBuf msg = Unpooled.copiedBuffer("hello world".getBytes(StandardCharsets.UTF_8));
//
//        System.out.println("send msg ... ");
//        ChannelFuture writeResult = clientSocket.writeAndFlush(msg);
//        writeResult.sync();
//
//        writeResult.channel().closeFuture().sync();
//
//        System.out.println("SERVICE END.");

        template();
    }

    public static void template() throws InterruptedException {
        NioEventLoopGroup thread = new NioEventLoopGroup(1);

        //客户端模式：
        NioSocketChannel client = new NioSocketChannel();

        thread.register(client);  //epoll_ctl(5,ADD,3)

        //响应式：
        ChannelPipeline p = client.pipeline();
        p.addLast(new MyInHandler());

        //reactor  异步的特征
        ChannelFuture connect = client.connect(new InetSocketAddress("127.0.0.1", 9090));
        ChannelFuture sync = connect.sync();

        ByteBuf buf = Unpooled.copiedBuffer("hello server".getBytes());
        ChannelFuture send = client.writeAndFlush(buf);
        send.sync();

        //马老师的多线程
        sync.channel().closeFuture().sync();

        System.out.println("client over....");
    }

    static class MyInHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("client  registed...");
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("client active...");
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("READ EVENT ...");
            ByteBuf buf = (ByteBuf) msg;
//        CharSequence str = buf.readCharSequence(buf.readableBytes(), CharsetUtil.UTF_8);
            CharSequence str = buf.getCharSequence(0,buf.readableBytes(), CharsetUtil.UTF_8);
            System.out.println(str);
            ctx.writeAndFlush(buf);
        }
    }
}
