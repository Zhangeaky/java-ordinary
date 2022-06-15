package se.io.net.server.selector;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;

public class selectLearning {



    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        int select = selector.select();

        Set<SelectionKey> keys = selector.keys();

        for (SelectionKey key: keys) {

            key.cancel(); //放入到取消队列

        }



        System.out.println("hello world");

    }
}
