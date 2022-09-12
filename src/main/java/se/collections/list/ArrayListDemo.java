package se.collections.list;
import se.java8.bean.BasketBallPlayer;

import java.util.Iterator;

import static se.java8.stream.StreamDemo3.players;

public class ArrayListDemo {

    public static void main(String[] args) {

        //一下造作都会对modCount进行增加
        players.add(null);
        players.remove(0);
        players.add(0,null);
        players.remove(null);
        players.removeIf(x->{
            return x.getName()==null;
        });
        players.retainAll(players);
        players.replaceAll(null);

        players.iterator();

        System.out.println(players.size());


    }
}
