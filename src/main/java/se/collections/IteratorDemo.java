package se.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * iterator 的 remove方法只有在进行遍历之后才能进行删除操作。
 *
 *
 */
public class IteratorDemo {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("yida", "tongshao", "yingkong", "yinmai");

        ArrayList<String> members = new ArrayList<>(strings);

        Iterator<String> iterator = members.iterator();

        System.out.println("list has " + strings.size() + " memebers.");


        while (iterator.hasNext()) {
            String next = iterator.next();
            iterator.remove();
            System.out.println("I am " + next);
        }

        //iterator.remove();

        System.out.println("list still has " + strings.size() + "members.");





    }
}
