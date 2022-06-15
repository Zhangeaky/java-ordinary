import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
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
                        ch.pipeline().addLast(hander);
                    }
                });

        ChannelFuture future = bootstrap.bind().sync();

        future.channel().closeFuture().sync();

        System.out.println("...");

    }
}

@ChannelHandler.Sharable
class MyHander extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


        ByteBuf content = (ByteBuf) msg;


        if (content.readableBytes() > 89) {
            System.out.println("readable sizes: " + content.readableBytes());
            ByteBuf byteBuf = content.readBytes(89);

            byte[] array = byteBuf.array();

            ByteArrayInputStream in = new ByteArrayInputStream(array);

            ObjectInputStream objectInputStream = new ObjectInputStream(in);
            Object o = objectInputStream.readObject();
            System.out.println(o.getClass());
        }

        //System.out.println("[Server] received msg: " + content.toString(CharsetUtil.US_ASCII));
        //ctx.write(content);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }
}
