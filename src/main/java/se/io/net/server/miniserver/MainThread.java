package se.io.net.server.miniserver;

/**
 *  主线程 负责 服务监听的创建
 *  资源分配和调度
 *
 */
public class MainThread {

    public static void main(String[] args) {

        WorkGroup group = new WorkGroup(3);

        group.bind(9090);


    }
}
