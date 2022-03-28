package standardEdition.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {


    public static void main(String[] args) {

        List<String> numbers = Arrays.asList("2111903193", "2111903891", "2111903191");

        numbers.stream()
                .map(x->x.substring(7,10))
                .skip(1)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Stream.concat(numbers.stream(), numbers.stream())
                .distinct()
                .forEach(System.out::println);


    }
}
