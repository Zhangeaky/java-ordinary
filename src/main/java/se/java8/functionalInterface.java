package se.java8;

import se.java8.bean.BasketBallPlayer;
import se.java8.stream.StreamDemo3;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class functionalInterface{

    public static StreamDemo3 instance = new StreamDemo3();

    public static void test01() {
        List<BasketBallPlayer> players = StreamDemo3.players;
        Map<String, Double> collect = players.stream().
                collect(Collectors.toMap(BasketBallPlayer::getName, BasketBallPlayer::getPts));

    }

    public static void test02() {

        BasketBallPlayer basketBallPlayer = Optional.ofNullable(StreamDemo3.players.get(5))
                .filter((x) -> {
                    return x.getName() != null;
                })
                .orElse(null);
        System.out.println(basketBallPlayer);

        Optional.ofNullable(StreamDemo3.players.get(5))
                .ifPresent((x)->{
                    System.out.println(x.getName());
                });


        //Optional.ofNullable()

    }

    public static void main(String[] args) {
        test02();
    }



}
