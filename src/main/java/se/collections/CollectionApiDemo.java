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

    static {
        demo1.add(1);
        demo1.add(3);
        demo1.add(5);
        demo1.add(7);
        demo1.add(9);
        demo1.add(11);
        demo1.add(13);
    }

    /**
     * 注意Arrays.asList生成的静态类
     *
     */
    private static void add() {

        System.out.println("[Judge]: demo1's type is " + demo1.getClass().getCanonicalName());
        System.out.println("[Judge]: demo2's type is " + demo2.getClass().getCanonicalName());

        instance.add(10);

        demo1.add(10);

       // demo2.add(10);


        HashSet<Integer> set = new HashSet<>(demo1);

        /**
         * Set 对象转换成自己的数组形式
         * 然后加在本集合的数组后面
         */
        demo1.addAll(set);

        demo1.forEach(System.out::println);

    }

    public static void contains() {

        Set<Integer> intes = new HashSet<>();
        intes.add(1);
        intes.add(3);
        intes.add(44);

        /**
         * 基本就是遍历然后比较 复杂度ON
         */
        boolean contains = demo1.contains(5);

        /**
         * 对每个元素调用contains方法
         */
        demo1.containsAll(intes);
        System.out.println("[Contains all result: ]" + demo1.containsAll(intes));

        /**
         * 留下原有集合中 含有入参集合的元素 曲交集
         *
         */
        boolean b = demo1.retainAll(intes);
        System.out.println("[retain all result: ] " + b );

        Iterator<Integer> iterator = demo1.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println("[elelment after retain] " + next);
        }



    }

    public static void main(String[] args) {

        //add();
        contains();

    }
}
