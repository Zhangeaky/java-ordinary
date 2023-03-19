package com.zhangeaky.algorithm.array;

/**
 * @Author: jiegege
 * @Date: 2022/3/20 2:24 PM
 * @address: hangzhou
 * @description: 给定一个升序的数组，删除重复项。
 * @Version 1.0
 */
public class RemoveDuplicates {


    public static int removeDuplicates(int[] input) {

        for(int i = 0; i < input.length-1; i++) {
            if (input[i] == input[i+1]) {
                moveArray(input, i);
            }
        }
        return 0;
    }

    private static void moveArray(int[] input, int index) {

        for (int i=index;i<input.length-1;i++) {
            input[i] = input[i+1];
        }
        if (input[index] == input[index +1]) {
            moveArray(input, index);
        }
    }

    public static String disPlayArray(int[] input, int num){
        StringBuilder result = new StringBuilder();
        for (int i=0; i < num; i++) {
            result = result.append(input[i]);
            result.append(" ");
        }
        return result.toString();
    }

    public static int solutionDoublePoint(int[] input){

        int left = 0;
        int right = 0;

        for (int i = 0; i < input.length-1; i ++) {
            right++;
            if(input[left] != input[right]){
                left++;
                input[left] = input[right];
            }
        }
        return left+1;
    }

    public static void main(String[] args) {

        int[] example = {1,2,2,2,3,3};

        System.out.println("Before :" + disPlayArray(example, example.length));

        int i = solutionDoublePoint(example);

        System.out.printf("After :" + disPlayArray(example, i) );

        //removeDuplicates(example);

    }

}
