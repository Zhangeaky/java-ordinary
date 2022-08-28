package se.java8.stream;

import se.java8.bean.BasketBallPlayer;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static se.java8.bean.BasketBallPlayer.POSITION;

public class StreamDemo3 {

    public static List<BasketBallPlayer> players = new ArrayList<>();
    static {
        players.add(new BasketBallPlayer("Harden. J", 36.1, 6.6, 7.5,POSITION.SHOTTING_GUARD, "13"));
        players.add(new BasketBallPlayer("George. P", 28.0, 8.2, 4.1, POSITION.SHOTTING_GUARD, "13"));
        players.add(new BasketBallPlayer("Antetokounpo. G", 27.7, 13.7, 5.8, POSITION.CENTER, "34"));
        players.add(new BasketBallPlayer("Embid. J", 27.5, 13.6, 3.7, POSITION.CENTER ,"21"));
        players.add(new BasketBallPlayer("Curry. S", 27.3, 5.3, 5.2, POSITION.POINT_GUARD ,"30"));
        players.add(new BasketBallPlayer("Leonard. K", 26.6, 7.3, 3.3, POSITION.SCORE_FORWARD ,"2"));
        players.add(new BasketBallPlayer("Booker. d", 26.6, 4.1, 6.8, POSITION.SCORE_FORWARD ,"2"));
        players.add(new BasketBallPlayer("Durant. K", 26.0, 6.8, 5.4, POSITION.SCORE_FORWARD ,"2"));
        players.add(new BasketBallPlayer("Lillard. D", 25.8, 4.6, 6.9, POSITION.SCORE_FORWARD ,"2"));
        players.add(new BasketBallPlayer("Walker. K", 25.6, 4.4, 5.9, POSITION.SCORE_FORWARD ,"2"));
        players.add(new BasketBallPlayer("Beal. B", 25.6, 5.0, 5.5, POSITION.SCORE_FORWARD ,"1"));
        players.add(new BasketBallPlayer("Griffin. B", 24.5, 7.5, 5.4, POSITION.SCORE_FORWARD ,"32"));
        players.add(new BasketBallPlayer("Towns. K-A", 24.4, 12.4, 3.4, POSITION.SCORE_FORWARD ,"2"));
        players.add(new BasketBallPlayer("Irving. K", 23.8, 5.0, 6.9, POSITION.SCORE_FORWARD ,"2"));

        players.get(0).setHornors(Arrays.asList("MVP", "得分王", "助攻王", "第一阵容"));
        players.get(1).setHornors(Arrays.asList("第一阵容"));
    }

    public static final List<String> MVP = Arrays.asList("Harden. J");

    //并行流
    public static void test01() {

        ForkJoinPool pool = new ForkJoinPool(1);

        pool.execute(() ->{
            IntStream.rangeClosed(0, 10000).parallel().forEach(x->{
                System.out.println(Thread.currentThread().getName() + "_" + x);
                //while (true);
            });
        });

        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static final Integer[] numbers1 = {1,3,5};

    public static final Integer[] numbers2 = {2, 4};

    public static void test02() {
        //{1,2} {1,4}  {3,2} {3,4} {5, 2} {5, 4}

        long count = Arrays.stream(numbers1).flatMap(x ->
                Arrays.stream(numbers2).map(y -> new Integer[]{x, y})
        ).filter(x->(x[0]+x[1])%3 ==0)
                .count();

        System.out.println(count);

    }

    // 查找和匹配
    public  static void test04() {

        Optional<BasketBallPlayer> first = players.stream().findFirst();
        Optional<BasketBallPlayer> any = players.stream().findAny();

        BasketBallPlayer basketBallPlayer = first.get();

    }


    /**
     * 对流进行收集
     */
    public static void test05() {

        //players.stream().collect(Collectors.toList())

    }

    // 规约
    public static void test03(){

        // 将Harden 和其他球员分为一类
        Map<String, List<BasketBallPlayer>> collect = players.stream().collect(Collectors.groupingBy((x) -> {
            if (x.getName().equals("Harden. J")) {
                return "得分王";
            } else {
                return "其他";
            }
        }));

        System.out.println(collect);




    }



    public static void main(String[] args) {

        Stream<BasketBallPlayer> stream = players.stream();

        //System.out.println(players.stream().filter(x -> x.getPts() > 27.0).map(BasketBallPlayer::getName).collect(Collectors.toList()));
        //players.stream().map(BasketBallPlayer::getName).forEach(System.out::println);
        // filter 和 anymatch

        //players.stream().anyMatch(players::contains);
        players.stream().map(x->{
            System.out.println(x.getName());
            return x.getRebs();
        }).limit(1).count();

       // stream.map(BasketBallPlayer::getName).map(x->x.split("")).forEach(x->Stream.of(x).forEach(System.out::println));

        //stream.map(BasketBallPlayer::getNumber).map(Integer::valueOf).map(x->x*x).forEach(System.out::println);

        // 得分 27+ 或者篮板 10+ 合集
        //ArrayList<BasketBallPlayer> basketBallPlayers = new ArrayList<>(players);

        //System.out.println(stream.map(BasketBallPlayer::getName).anyMatch(MVP::contains));

        //stream.findAny()
        System.out.println(stream.map(BasketBallPlayer::getHornors)
                        .filter(Objects::nonNull)
                .flatMap(Collection::stream).collect(Collectors.toList()));

        System.out.println("Map-reduce的联系");
        Double reduce = players.stream().map(BasketBallPlayer::getPts).reduce(0.0, Double::sum);
        System.out.println(reduce);

        double sum = players.stream().mapToDouble(BasketBallPlayer::getPts).sum();
        System.out.println("[Sum points from serveral all stars] " + sum);


        Double MaxPts = players.stream().map(BasketBallPlayer::getPts).reduce(0.0, Math::max);
        System.out.println("【得分王的最高分】: " + MaxPts);

        OptionalDouble max = players.stream().mapToDouble(BasketBallPlayer::getPts).max();
        System.out.println("max point of the best: " + max);


        Double maxRebs = players.stream().map(BasketBallPlayer::getRebs).reduce(0.0, Math::max);
        System.out.println("【篮板王的篮板数】：" + maxRebs );


        Integer[] gameScores = new Integer[]{10, 18, 22, 30, 15, 4, 15, 12, 10, 20,
                                            22, 18, 20, 7, 9, 20, 30, 20, 12, 11};


        DoubleSummaryStatistics collect = players.stream().collect(Collectors.summarizingDouble(BasketBallPlayer::getPts));
        double average = collect.getAverage();
        System.out.println(average);

        System.out.println("平均的分相加" + players.stream().collect(Collectors.summingDouble(BasketBallPlayer::getPts)));

        System.out.println("名字拼接" +  players.stream().map(BasketBallPlayer::getName).
                collect(Collectors.joining("__")) );


        Map<POSITION, List<BasketBallPlayer>> groups = players.stream().collect(Collectors.groupingBy(BasketBallPlayer::getPosition));

        for (Map.Entry entry : groups.entrySet()) {
            String a = " " + entry.getKey() + entry.getValue();
            System.out.println(a);
        }


        test03();



    }
}


/**
 *  given two list [1, 2, 3]  [2, 4]
 *  generate lists such as [1, 2] [1, 4] for response
 *
 *
 */
class test2 {
    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(2, 4);

        List<Integer[]> collect = l1.stream()
                .flatMap(x ->
                        l2.stream().map(y -> new Integer[]{x, y})  // 这段代码产生的是若干个流 只能使用flatmap去承接
                ).collect(Collectors.toList());

        collect.stream().map(Arrays::asList).forEach(System.out::println);

        // 生成可以被 5 整除的流
        List<Integer[]> collect1 = l2.stream().flatMap(x ->
                l1.stream().filter(y -> (x + y) % 5 == 0)
                        .map(y -> new Integer[]{y, x})
        ).collect(Collectors.toList());

        collect1.stream().forEach( x -> {

            List<Integer> integers = Arrays.asList(x);
            integers.stream().forEach(System.out::println);
        });

        long count = Stream.of(l1, l2).count();
        Stream.of(l1, l2).forEach(System.out::println);
        System.out.println(Stream.of(l1, l2));

        System.out.println("count: " + count);



    }
}
