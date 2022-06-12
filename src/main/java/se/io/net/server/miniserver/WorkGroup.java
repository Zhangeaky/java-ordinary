package se.io.net.server.miniserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkGroup {

    private SelectorThread[] workers;

    private AtomicInteger index = new AtomicInteger(0);

    WorkGroup(int numbers) {

        workers = new SelectorThread[numbers];

        for (int i=0; i < numbers; i++) {

            workers[i] = new SelectorThread();
            workers[i].setWkBlonged(this);

            new Thread(workers[i]).start();
        }

    }

    public void bind(int port) {

        try {
            ServerSocketChannel server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(port));
            server.configureBlocking(false);

            //后续使用Optional优化
            if (workers[0] != null) {
                System.out.println("开始注册server ... ");
                Selector selector = workers[0].getSelector();
                workers[0].getLinkedBlockingQueue().add(server);
                selector.wakeup();
                //server.register(selector, SelectionKey.OP_ACCEPT);
                //System.out.println("注册成功.");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public SelectorThread[] getWorkers() {
        return workers;
    }

    public AtomicInteger getIndex() {
        return index;
    }
}
