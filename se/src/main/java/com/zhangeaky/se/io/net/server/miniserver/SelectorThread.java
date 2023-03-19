package com.zhangeaky.se.io.net.server.miniserver;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class SelectorThread implements Runnable{

    private WorkGroup wkBlonged;

    private Selector selector;

    private LinkedBlockingQueue<Channel> linkedBlockingQueue = new LinkedBlockingQueue<>();


    SelectorThread() {

        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {

        while (true) {

            try {
                //1. select
                System.out.format("%s is running at before point.\n", Thread.currentThread().getName());
                int numbers = selector.select();// 如果不加timeout 参数 该方法就会一直阻塞 wakeUp()会把他叫醒执行后面
                System.out.format("%s is running at after point. keys is %d\n",
                        Thread.currentThread().getName(), selector.keys().size());

                if (numbers > 0) {

                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();

                    while (iterator.hasNext()) {

                        SelectionKey key = iterator.next();
                        // TODO: 2022/6/10 这个原理要弄明白
                        iterator.remove(); // 这是什么骚操作

                        if (key.isAcceptable()) {
                            handleAcceptable(key);

                        }else if (key.isReadable()) {

                        }else if (key.isWritable()) {

                        }
                    }
                }

                if (!linkedBlockingQueue.isEmpty()) {
                    register();
                }


            }catch (Exception e) {
                e.printStackTrace();
            }



        }

    }

    private void handleAcceptable(SelectionKey key) throws IOException {

        System.out.println("[acceptHanle]Begin service ....");
        SelectableChannel channel = key.channel();

        System.out.println("is channel serverScokert :" + (channel instanceof ServerSocketChannel));
        ServerSocketChannel server = (ServerSocketChannel) channel;

        /* 如果没有对serverSocket 进行accept 处理 那么该描述符的状态不会被清除 所以SELECTOR 会永远处于有状态 */
        SocketChannel client = server.accept();

        //要Jiang client 放入到thread 的selector里面去.
        SelectorThread targetThread = fetchThread();
        targetThread.getLinkedBlockingQueue().add(client);
        targetThread.getSelector().wakeup();

        System.out.println("[acceptHanel]End Service ...");


    }

    private SelectorThread fetchThread() {

        System.out.println("[fetchThread] Service begin ...");
        int random = wkBlonged.getIndex().incrementAndGet();
        System.out.println("random: " + random);
        SelectorThread[] workers = wkBlonged.getWorkers();
        int index = random % workers.length;
        System.out.println("index: " + index);
        System.out.println("[fetchThread] Service end ...");
        return this.wkBlonged.getWorkers()[index == 1 ? 2 : index ];
    }

    private void register() throws Exception {
        System.out.println("register begin.");
        Channel channel = linkedBlockingQueue.take();
        System.out.println(channel);

        if (channel instanceof ServerSocketChannel) {
            ServerSocketChannel server = (ServerSocketChannel) channel;
            server.register(this.selector, SelectionKey.OP_ACCEPT);
            System.out.format("%s 注册server success.\n", Thread.currentThread().getName());
        } else {
            SocketChannel client = (SocketChannel) channel;
            // 必须配置配置配置为非阻塞否则回抛出异常
            client.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
            client.register(this.selector, SelectionKey.OP_READ, buffer); //不是很懂 要搞明白
            System.out.format("%s 注册client success.\n", Thread.currentThread().getName());
        }
        System.out.println("Register end.");


    }


    public void setWkBlonged(WorkGroup wkBlonged) {
        this.wkBlonged = wkBlonged;
    }

    Selector getSelector() {
        return selector;
    }

    public LinkedBlockingQueue<Channel> getLinkedBlockingQueue() {
        return linkedBlockingQueue;
    }
}
