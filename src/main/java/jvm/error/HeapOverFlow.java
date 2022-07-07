package jvm.error;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiegege
 * @Date: 2022/1/2 6:13 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class HeapOverFlow {

    static class oomObject {

        Long id = 1L;
        long id2 = 2L;
        List<Integer> list = new ArrayList<>(10000);


    }

    public static void main(String[] args) {

        List<oomObject> list = new ArrayList<>();

        while (true) {
            list.add(new oomObject());
        }
    }
}
