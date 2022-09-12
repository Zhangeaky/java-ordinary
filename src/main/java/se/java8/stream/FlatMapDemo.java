package se.java8.stream;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

public class FlatMapDemo {

    public static final String config = "[{\"mids\": [\"1235\", \"24\", \"44\"]},{\"mids\": [\"2435\", \"24\", \"2749\"]},{\"mids\": [\"6830\", \"273\", \"222\"]}]";

    public static void main(String[] args) {

        List<Map> list = JSON.parseObject(config, List.class);

        List mids = (List)list.stream().map(x -> {
                    return (List) x.get("mids");
                }).flatMap(Collection::stream).collect(toList());
        System.out.println(mids.getClass());


    }
}
