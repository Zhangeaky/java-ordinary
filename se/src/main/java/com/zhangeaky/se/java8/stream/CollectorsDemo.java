package com.zhangeaky.se.java8.stream;

import com.zhangeaky.se.java8.bean.BasketBallPlayer;

import java.util.Map;
import java.util.stream.Collectors;

import static com.zhangeaky.se.java8.stream.StreamDemo3.players;
import static java.util.stream.Collectors.*;

/**
 *
 *
 *
 *
 */
public class CollectorsDemo {

    public static void main(String[] args) {

        players.add(new BasketBallPlayer("Harden. J", 10.0, 10.0, 10.0,
                BasketBallPlayer.POSITION.CENTER, "10"));

        Map<String, String> list = players.stream()
                .collect(Collectors.toMap(BasketBallPlayer::getName, BasketBallPlayer::getNumber));

        System.out.println(list);

        players.stream().collect(summingDouble(BasketBallPlayer::getPts));

    }

}
