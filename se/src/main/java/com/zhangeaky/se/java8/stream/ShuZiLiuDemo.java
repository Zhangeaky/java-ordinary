package com.zhangeaky.se.java8.stream;

import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ShuZiLiuDemo {


    public static void main(String[] args) throws IOException {

        IntStream ii = IntStream.rangeClosed(0, 100);
        ii.parallel().forEach((x)->{
            System.out.println("Thread name is " + Thread.currentThread().getName() + " " + x);
        });

//        Stream<String> lines = Files.lines(Paths.get("/Users/kimchang/vocabulary.txt"), Charset.defaultCharset());
//
//        lines.map(x-> x.split(" ")).forEach(x-> Stream.of(x).distinct().forEach(System.out::println));
//
//        Stream.iterate(0, x->x+2).forEach(System.out::println);

        // 普通流转换为数字流
        int sum = Stream.of(1, 3, 5, 7, 9)
                .mapToInt(x -> x).sum();





    }
}
