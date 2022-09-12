package se.io.nettysth.rpc;

import se.bean.Person;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import se.io.nettysth.rpc.facade.AgreementPayService;
import se.io.nettysth.rpc.facade.request.AgreementPayRequest;
import se.io.nettysth.rpc.facade.response.AgreementPayResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 *
 *  1. 动态代理 序列化 协议封装
 *  2.
 *  3. 就像调用本地方法一样去调用远程方法
 *
 *
 *
 */
public class RPCTest {


    public static Header createHeader() {

        Header header = new Header();
        header.setRequestId(UUID.randomUUID().toString().hashCode());


        return header;
    }


    public static <T>T proxyGet(Class<T> input) {
        //各个动态代理版本实现自己

        ClassLoader classLoader = input.getClassLoader();

        Class<?>[] classes = {input};



        return (T)Proxy.newProxyInstance(classLoader,classes, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("pay invoking ...");
                //消息体 1. 对象名 方法名 方法参数 参数内容


                // requestId versionId dataLength
                System.out.println("args number: " + args.length);

                String canonicalName = input.getCanonicalName();
                System.out.println("className: " + canonicalName);

                String methodName = method.getName();
                System.out.println("methodName: " + methodName);

                Payload payload = new Payload();
                payload.setArgsType(method.getParameterTypes());
                payload.setClassName(canonicalName);
                payload.setArgs(args);
                payload.setMethodName(methodName);

                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ObjectOutputStream objout = new ObjectOutputStream(out);
                objout.writeObject(payload);
                System.out.println("serialized obj size: " + out.toByteArray().length);
                byte[] byteLoad = out.toByteArray();

                Header header = new Header();

                header.setRequestId(UUID.randomUUID().toString().hashCode());
                header.setVersion(0x0000-0000-0000-0000);
                header.setDateLength(0);
                out.reset();
                objout.writeObject(header);

                byte[] byteHeader = out.toByteArray();

                System.out.println("header size :" + out.toByteArray().length);

                ByteBuf pool = UnpooledByteBufAllocator.DEFAULT.directBuffer(byteHeader.length+byteLoad.length);

                // 3. TODO: 2022/6/14 准备连接池 每一个c-s连接一个连接池  连接池可能会有并发使用 所以要加锁
                // 开始 - 创建 以及运行中 直接获取
                // 连接池 对应一个socket文件

                Bootstrap bootstrap = new Bootstrap();
                NioEventLoopGroup group = new NioEventLoopGroup(1);
                bootstrap.group(group)
                        .remoteAddress(new InetSocketAddress("127.0.0.1", 12220))
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<NioSocketChannel>() {

                            @Override
                            protected void initChannel(NioSocketChannel ch) throws Exception {

                                ch.pipeline().addLast(new SimpleChannelInboundHandler<Object>() {
                                    @Override
                                    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
                                        System.out.println("response" + msg);
                                    }
                                });

                            }
                        });
                ChannelFuture connect = bootstrap.connect();

                try {

                    ChannelFuture sync = connect.sync();

                    Channel channel = sync.channel();

                    pool.writeBytes(byteHeader);
                    pool.writeBytes(byteLoad);
                    ChannelFuture future = channel.writeAndFlush(pool);


                }catch (Exception e) {
                    e.printStackTrace();
                }


                // TODO: 2022/6/14 注册

                // 4. TODO: 2022/6/14  发送信息



                CountDownLatch latch = new CountDownLatch(1);

                latch.await();

                // 5. TODO: 2022/6/14  channel.writeAndFlush 字节数组拼接


                //----countDownLatch 消息没有回来之前应该一直被阻塞着
                // 用观察者模式去实现，消息一回来直接 countdown 程序就会往下走

                // 6. TODO: 2022/6/14 响应处理
                System.out.println("...");
                
                
                return null;
            }
        });
    }


    public static void main(String[] args) throws IOException {

        ByteArrayOutputStream byteInstance = new ByteArrayOutputStream();
        System.out.println(byteInstance.size());


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteInstance);

        objectOutputStream.writeObject(new Person());
        System.out.println(byteInstance.size());


        AgreementPayRequest request = new AgreementPayRequest();

        AgreementPayResponse response = proxyGet(AgreementPayService.class).pay(request);





    }
}


class ResponseHandler {

    static ConcurrentHashMap<Long, Runnable> mapping = new ConcurrentHashMap<>();

    public static void addCallback(Long requestId, Runnable thread) {

        mapping.putIfAbsent(requestId, thread);
    }

    public static void callBack(Long requestId) {
        mapping.get(requestId).run();
        mapping.remove(requestId);
    }
}

class Header implements Serializable {

    private static final long serialVersionUID = -3040866867239365313L;

    public Header() {
    }

    private int version;

    private int requestId;

    private int dateLength;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getDateLength() {
        return dateLength;
    }

    public void setDateLength(int dateLength) {
        this.dateLength = dateLength;
    }
}

class Payload implements Serializable{

    private static final long serialVersionUID = -8878977203863444453L;
    private String className;

    private String MethodName;

    private Class<?>[] argsType;

    private Object[] args;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return MethodName;
    }

    public void setMethodName(String methodName) {
        MethodName = methodName;
    }

    public Class<?>[] getArgsType() {
        return argsType;
    }

    public void setArgsType(Class<?>[] argsType) {
        this.argsType = argsType;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}

class ResponseGetCallback{

    private CountDownLatch latch;

    public ResponseGetCallback(CountDownLatch latch) {
        this.latch = latch;
    }

    public void doCallback() {
        latch.countDown();
    }
}

