import org.junit.Test;

import java.util.stream.Stream;

public class AlgoTest {

    private static Integer[] temp(Integer[] input) {

        if ( input == null ||input.length <2 ) {
            return input;
        }

        for (int i = 0; i < input.length-1 ; i++) {

            int minIndex = i;

            for (int j = i; j < input.length; j++) {

                minIndex = input[j] < input[minIndex] ? j : minIndex;

            }

            swap(minIndex, i, input);

        }
        return input;
    }





    //选择排序测试
    private static Integer[] sortSelect(Integer[] input) {

        if (input == null || input.length < 2 ) {
            return input;
        }

        for (int i = 0 ; i < input.length-1; i++) {
            for (int j = i +1 ; j < input.length; j++) {
                if (input[j] < input[i] ) {
                    swap(i, j, input);
                }
            }
        }
        return input;
   }

   @Test
   public void test() {

        Integer[] inputbatch = {3,2,8,1,5,3};
        Integer[] data1 = {1,2,1,2,1,2};
        Integer[] input = {6,5,4,3,2,1};
       Integer[] result = temp(data1);
       Stream.of(result).forEach(System.out::println);

      // Stream.of(inputbatch).sorted().forEach(System.out::println);




   }

    public static void swap (int one, int two, Integer[] input) {
        int temp = input[one];
        input[one] = input[two];
        input[two] = temp;
    }


    // 插入排序测试
    public int[] sortInsertion(int[] input) {

        //边界
        if ( input == null ||input.length < 2 ) {
            return input;
        }
//
//        for () {
//
//        }
//
        return input;
    }


}
