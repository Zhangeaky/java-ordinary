package standardEdition.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author kimchang
 *
 * @data :
 * @description :  Iterator 的 remove() next() 方法测试
 *              JAVA8 -> removeIf(Predicate<>)
 *
 */
public class DemoTest {


    public static void main(String[] args) {
        Collection<String> container = new ArrayList<>(5);

        container.add("yida");
        container.add("gande");
        container.add("lusu");
        container.add("miaorenfeng");
        container.add("wanganshi");
        container.add("yymmdd");

        Iterator<String> iterator = container.iterator();
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(container);
        iterator.next();
        iterator.remove();
        System.out.println(container);

        container.removeIf( a -> a.charAt(0) == 'y');
        System.out.println(container);

        try {
            iterator.remove();
        }catch (Exception ex) {
            //System.out.println(ex);
        }

        Object[] objects = container.toArray();
        System.out.println(objects);


    }
}
