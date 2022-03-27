import org.junit.Test;

import java.util.stream.Stream;

public class AlgoTest {

    //选择排序测试
    private static Integer[] sortSelect(Integer[] input) {

        if (input == null || input.length < 2 ) {
            return input;
        }

        for ( int i = 0; i < input.length; i ++) {
            for (int j = i; j < input.length ; j++) {
                if (input[j] < input[i]) {
                    swap(j, i, input);
                }
            }
        }
        return input;
   }

   @Test
   public void test() {

        Integer[] input = {6,5,4,3,2,1};
       Integer[] result = sortSelect(input);
       Stream.of(result).forEach(System.out::println);




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
