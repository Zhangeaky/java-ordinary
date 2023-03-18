package se.alibabahandbook;

import se.java8.bean.BasketBallPlayer;

import java.util.*;
import java.util.stream.Collectors;

import static se.java8.stream.StreamDemo3.players;

public class CollectionsChapter {

    /**
     * equals 方法 和 hashCode 方法
     *  因为
     *
     *
     */

    public static void test01() {

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("a");

        Set<String> strings = new HashSet<>(list);




    }


    public static void test02() {

        Map<String, String> jj = new HashMap<>();



        Iterator<BasketBallPlayer> iterator = players.iterator();

        while (iterator.hasNext()) {

            BasketBallPlayer next = iterator.next();

            if (next.getPts()<25.0) players.remove(next);
            iterator.remove();

        }



    }


    /**
     *
     *
     */

    public static void test() {

        players.add(new BasketBallPlayer("jihui", null, null,null, null, null));

        Map<String, String> collect = players.stream().
                collect(Collectors.toMap(BasketBallPlayer::getName, BasketBallPlayer::getNumber));

    }

    public static void subList() {

        List<BasketBallPlayer> basketBallPlayers = players.subList(0, players.size());
        basketBallPlayers.removeIf(x->
            x.getName() != null
        );
        System.out.println(players);



    }


    public static void keyset() {
        Map<String, String> collect = players.stream()
                .collect(Collectors.toMap(BasketBallPlayer::getName, BasketBallPlayer::getNumber));

        System.out.println(collect);
        collect.keySet().remove("Harden. J");
        System.out.println(collect);
    }

    public static void main(String[] args) {
        //test();

        //subList();

        keyset();

        HashMap<String, String> map = new HashMap<>(16);
        map.put("james", "23");
        map.get("james");
    }


}
