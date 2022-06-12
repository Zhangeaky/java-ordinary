package standardEdition.io;

import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyDemo {

    public static void main(String[] args) {

        try {

            NioSocketChannel nioSocketChannel = new NioSocketChannel();

            NioEventLoopGroup eventExecutors = new NioEventLoopGroup(1);

            ChannelFuture register = eventExecutors.register(nioSocketChannel);
            register.sync();

        } catch (Throwable t) {

        }




    }
}
