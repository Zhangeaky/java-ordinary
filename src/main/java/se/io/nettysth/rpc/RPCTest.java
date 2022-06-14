package se.io.nettysth.rpc;

import bean.Person;
import se.io.nettysth.rpc.facade.AgreementPayService;
import se.io.nettysth.rpc.facade.request.AgreementPayRequest;
import se.io.nettysth.rpc.facade.response.AgreementPayResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

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


    public static <T>T proxyGet(Class<T> input) {
        //各个动态代理版本实现自己

        ClassLoader classLoader = input.getClassLoader();

        Class<?>[] classes = {input};


        return (T)Proxy.newProxyInstance(classLoader,classes, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("pay invoking ...");
                // TODO: 2022/6/14  准备消息体 消息头
                // requestId versionId dataLength


                // 3. TODO: 2022/6/14 准备连接池 每一个c-s连接一个连接池  连接池可能会有并发使用 所以要加锁
                // 开始 - 创建 以及运行中 直接获取


                // TODO: 2022/6/14 注册

                // 4. TODO: 2022/6/14  发送信息

                // 5. TODO: 2022/6/14  channel.writeAndFlush 字节数组拼接


                //----countDownLatch 消息没有回来之前应该一直被阻塞着
                // 用观察者模式去实现，消息一回来直接 countdown 程序就会往下走

                // 6. TODO: 2022/6/14 响应处理
                
                
                
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
