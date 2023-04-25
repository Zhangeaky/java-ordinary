package com.zhangeaky.algorithm.zuo.getMinQueue;

/**
 * 设计一个具有getMin 方法的栈
 */
public class Solution {

    public static void main(String[] args) {

        StackOfMethod1 stack = new StackOfMethod1();
        stack.push(5);
        stack.push(6);
        stack.push(9);
        stack.push(4);
        stack.push(1);
        stack.pop(); stack.pop(); stack.pop();
        System.out.println("最小： " +stack.getMin());


    }






}
