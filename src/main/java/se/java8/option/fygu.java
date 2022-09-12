package se.java8.option;


import se.java8.bean.BasketBallPlayer;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

import static se.java8.stream.StreamDemo3.players;
public class fygu {

    /**
     *  orElse
     *  orElseGet
     *
     */
    public void test01() {

        Optional.ofNullable(players.get(ThreadLocalRandom.current().nextInt(10)))
                .ifPresent(System.out::println);


        Optional.ofNullable(players.get(ThreadLocalRandom.current().nextInt(10)));

        BasketBallPlayer basketBallPlayer = Optional.ofNullable(players.get(0)).get();






    }

    public static void main(String[] args) {

        String nba_player = Optional.ofNullable(players.get(10))
                .map(BasketBallPlayer::getName).orElse("NBA Player");

        System.out.println(nba_player);

        String s = Optional.ofNullable(players.get(new Random().nextInt(10)))
                .filter(x -> x.getPts() > 35.0)
                .map(BasketBallPlayer::getName)
                .orElseGet(() -> {
                    return System.getProperty("classpath");
                });

        //ThreadPoolExecutor

        System.out.println("s: " + s);



    }
}
