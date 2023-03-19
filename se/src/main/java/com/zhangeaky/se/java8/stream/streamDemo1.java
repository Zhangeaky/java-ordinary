package com.zhangeaky.se.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author kimchang
 * @description
 *  操作数组和集合的api
 *  1. 代码简洁 告别for 循环
 *  2. 并行计算
 *  3. stream 不是数据结构 没有内部存储
 *  4. 不支持随机访问， 延迟计算 **懒执行(只有在有终止操作的时候，中间代码才会被执行)**
 *  5. 过滤 查找 转换 汇总 聚合
 *  6. 源 中间操作 (0个或者N个中间操作); 终止操作,只有一个
 *  7. 只有遇到终止操作才开始遍历 源
 *  8. 抛开集合没有任何意义
 *
 */
public class streamDemo1 {

    /**
     * 生成操作
     *  api : Steam.of()
     *         list.stream()
     * @see java.util.function.Consumer
     *
     */
    public static void generate() {

        System.out.println("创建流的方式演示： ");

        // 1. Stream.of() 针对数组类型创建流
        System.out.println("1. Stream.of 创建: 用于将数组创建成流 ");
        String[] arrs = {"a","fd","g"};

        Stream<String> cityStream = Stream.of("BeiJing", "Rome", "HangZhou", "ShangHai");

        Stream<String> arrs1 = Stream.of(arrs);
        arrs1.forEach(System.out::println);//运用到 conumser

        // 2. Colletion.stream()
        System.out.println("2. 使用Colletion 集成stream()方法");
        List<String> stringList = Arrays.asList(arrs);
        Stream<String> stream = stringList.stream();
        stream.forEach(System.out::println);

        //3.
        System.out.println("Stream generate API");
        Stream<Integer> generate = Stream.generate(() -> 2);
        generate.limit(10).forEach(System.out::println);

        //4. 创建无线流的两种方式 iterate generate
        System.out.println("[4. 创建无限流的举例]");
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(1000).forEach(System.out::println);

        //5. 其他方式创建。
        String name = "zhangeaky";
        IntStream chars = name.chars();
        chars.forEach(System.out::println);


        Integer[] data = {1,2,3,4,5,6,7};
        Arrays.stream(data, 3, 6).forEach(System.out::println);

        Stream.of(data).map(x-> (long)x);

    }

    /**
     * 中间操作
     * filter 返回对子那个为Stream 就是中间操作
     *
     * @see java.util.Comparator
     */
    public static void interOperation() {

        System.out.println("Stream 中间操作演示");

        List<String> strings = Arrays.asList("zhangeaky", "lisi", "wangwu", "zhangsan");

        long count = strings.stream().filter(string -> string.charAt(0) == 'z').count();
        System.out.println(count);

        //IntStream 的 sum api 可以计算集合中的总和累加
        //Stream的 mapInt api 可以进行流的转换。
        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum());

        Optional<Integer> max = Arrays.asList(1, 2, 3, 99).stream().max((a, b) -> a - b);
        System.out.println(max.get());

        List<Integer> integers = Arrays.asList(4, 5, 6, 7);
        Optional<Integer> any = integers.stream().filter(x -> x > 5).findAny();
        Optional<Integer> first = integers.stream().filter(x -> x > 4).findFirst();
        System.out.println(any.get());

        Optional<Integer> first1 = integers.stream().sorted().findFirst();
        // 找出最大值
        Optional<Integer> first2 = integers.stream().sorted((a, b) -> b - a).findFirst();

        System.out.println(first2.get());

        /// TODO: 2022/3/28  集合元素过滤再返回一个新的集合元素 , 用的比较多 要注意。
        List<String> collect = strings.stream().filter(x -> x.charAt(0) == 'z').collect(Collectors.toList());


        collect.forEach(System.out::println);


        //去重操作
        Arrays.asList(1,1,1,1,1,2,2,2).stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
        Arrays.asList(1,1,1,2,2,2,3,3,3,4,4,4).stream().collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("打印数据操作 ： ");

        //打印 20 -30 的数据
        // skip 操作
        Stream.iterate(1,x->x+1).limit(10).skip(5).forEach(System.out::println);

       // Arrays.asList(1,2,3).stream().
        String content = "1,2,3,4,5,6,7,8,9,10";
        //方法引用
        int sum = Stream.of(content.split(",")).mapToInt(Integer::valueOf).sum();
        int sum1 = Stream.of(content.split(",")).map(Integer::valueOf).mapToInt(x -> x).sum();
        System.out.println(sum);

        //自定义对象

        String[] names = {"zhang", "wang", "li", "zhao", "zheng", "zhou", "he", "luo"};
        Integer[] ages = {18,19,8,7,8,9,3,19};

        //Stream.of(names).map(x-> Person.build(x,"1")).forEach(System.out::println);

        //peek()
        Stream<String> peek = Stream.of(names).peek(System.out::println);

        boolean q = Stream.of(names).allMatch(x -> x.charAt(0) == 'z');
        //boolean z = Stream.of(names).anyMatch(x -> x.contains('z'));

    }

    /**
     * 流操作不会改变原有的数据结构
     */
    public static void test03() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        List<Integer> collect = list.stream().filter(x -> x > 4).collect(Collectors.toList());
        System.out.println("result" + collect);
        System.out.println("original " + list);


    }

    public static void main(String[] args) {

        //test1();
        //generate();

        //interOperation();

        test03();


    }



}
