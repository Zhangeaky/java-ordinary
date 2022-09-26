package algorithm.basic;

/**
 *
 * @author kimchang
 * @description
 *   1. 算法复杂度  数据量和运行时间的关系。 最差情况来估计你的流程。
 *     1.1 时间复杂度。 常数时间操作。加减乘除。常数时间复杂度，只要是同类型相加，不管数据多复杂，时间是一样的。
 *      寻址操作。赋值操作; 如果一个操作时间不固定那就不是常数时间的操作。
 *     1.2 额外空间复杂度。<> ni </>
 *
 *   2. 选择排序
 *      冒泡排序(复杂度与数据的乱序程度吴无关)
 *      **插入排序(复杂度在好的情况下复杂度较低)**
 *   3.
 *   4.
 *   5.
 *
 *
 * @version
 */
public class demo1 {

    public static int[] temp(int[] input) {

        if (input == null || input.length < 2) {
            return input;
        }
        //
        for (int i = 0; i < input.length-1; i++) {

            int min_index = i;
            for (int j = i; j <= input.length-1; j++) {

                min_index = input[min_index] > input[j] ? j : min_index;

            }

            swap(i, min_index, input);
        }

        return input;

    }

    /**
     * 选择排序
     * @description 左老师解法
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ N-1  找到最小值，在哪，放到0位置上
        // 1 ~ n-1  找到最小值，在哪，放到1 位置上
        // 2 ~ n-1  找到最小值，在哪，放到2 位置上
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // i ~ N-1 上找最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap( i, minIndex,arr);
        }
    }


    /**
     * 我的解法 2022.0328
     * @description : 选择排序
     * @param input
     * @return
     */
    public static int[] sortSelect(int[] input) {
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

    /**
     *
     *
     * @param input
     * @return
     */
    public static int[] sortInsertion(int[] input) {

        //边界条件
        if ( input.length < 2 ) {
            return input;
        }

        /**
         * j+1 是当前游标, 游标的初始值是 i
         * j 是游标前一个数
         * 游标前一个数一定是游标前所有数里面最大的
         */
        for (int i = 1; i < input.length; i++ ) {
            for (int j = i-1; j>=0 && input[j] > input[j+1]; j--) {
                swap(j,j+1, input);
            }
        }

        return input;
    }

    private static void swap(int one, int two, int[] arr) {
        int tmp = arr[one];
        arr[one] = arr[two];
        arr[two] = tmp;
    }

    public int[] sortBubble(int[] input) {

        return null;


    }

    public static void main(String[] args) {

        int[] arr = new int[]{5,4,3,2,1};
        int[] test2 = new int[]{1,5,8,6,7,1,1,9,4,1,2};
        //sortInsertion(arr);
       // int[] ints = sortSelect(test2);


    }
}
