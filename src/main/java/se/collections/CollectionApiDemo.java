package se.collections;

import java.util.*;

/**
 * 测试 Collection interface api
 *
 */
public class CollectionApiDemo {

    private static Collection<Integer> demo1 =  new ArrayList<>();

    private static Collection<Integer> demo2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    private static ArrayList<Integer> instance = new ArrayList<>();


    /**
     * 注意Arrays.asList生成的静态类
     *
     */
    private static void add() {

        System.out.println("[Judge]: demo1's type is " + demo1.getClass().getCanonicalName());
        System.out.println("[Judge]: demo2's type is " + demo2.getClass().getCanonicalName());


        instance.add(10);

        demo1.add(10);


        demo2.add(10);


        HashSet<Integer> set = new HashSet<>(demo1);

        demo1.addAll(set);

        demo1.forEach(System.out::println);

    }

    public static void main(String[] args) {

        add();

    }
}
