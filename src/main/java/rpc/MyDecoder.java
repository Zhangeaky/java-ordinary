package rpc;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class MyDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        System.out.println("[decoder] ...");
        if (in.readableBytes() > 4) {
            out.add(in.readInt());
        } else {
            System.out.println("not ready to be read.");
        }

    }
}
