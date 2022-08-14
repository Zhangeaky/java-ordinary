package se.java8.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ShuZiLiuDemo {


    public static void main(String[] args) throws IOException {

        IntStream.rangeClosed(0, 100);

        Stream<String> lines = Files.lines(Paths.get("/Users/kimchang/vocabulary.txt"), Charset.defaultCharset());

        lines.map(x-> x.split(" ")).forEach(x-> Stream.of(x).distinct().forEach(System.out::println));

        Stream.iterate(0, x->x+2).forEach(System.out::println);


    }
}
