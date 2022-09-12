package se.collections.iterator;


import se.java8.bean.BasketBallPlayer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

import static se.java8.stream.StreamDemo3.players;

public class IteratorDemo {

    /**
     * 因为iterator 初始的情况下 指向第一个元素，上一个引用过的元素为-1
     * 如果没有调用过 next() 就会是这种状态
     */
    public static void remove_exception_case() {

        Iterator<BasketBallPlayer> iterator = players.iterator();
        iterator.remove();

    }

    public static void test_what_is_iterator() {
        Iterator<BasketBallPlayer> iterator = players.iterator();
        Iterator<BasketBallPlayer> iterator1 = players.iterator();
        System.out.println(iterator1.equals(iterator));


    }


    public static void listIterator_case() {

        ListIterator<BasketBallPlayer> listIterator = players.listIterator();

        while (listIterator.hasNext()) {

            System.out.println(
                    "next(): " + listIterator.next() +
                            "  nextIndex()" + listIterator.nextIndex() +
                            "  previousIndex()" + listIterator.previousIndex()
            );
        }

        while (listIterator.hasPrevious()) {

            System.out.println(listIterator.previous().getName());


        }


    }
    
    

    public static void remove() {
        Iterator<BasketBallPlayer> iterator = players.iterator();
        Map<String, Double> collect = players.stream()
                .collect(Collectors.toMap(BasketBallPlayer::getName, BasketBallPlayer::getPts, (a, b) -> a));

       new HashSet<>().iterator();


    }


    public static void main(String[] args) {

        //remove_exception_case();

        //listIterator_case();

        test_what_is_iterator();



    }
}
