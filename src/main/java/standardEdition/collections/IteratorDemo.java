package standardEdition.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("yida", "tongshao", "yingkong", "yinmai");

        ArrayList<String> members = new ArrayList<>(strings);

        Iterator<String> iterator = members.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            iterator.remove();

            System.out.println("I am " + next);

        }

        System.out.println(iterator.hasNext());




    }
}
