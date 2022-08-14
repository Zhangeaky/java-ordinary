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



    }
}

class test2 {
    public static void main(String[] args) {

        //StreamDemo3.test01();
        StreamDemo3.test02();


    }
}
