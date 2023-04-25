package com.zhangeaky.algorithm.zuo.getMinQueue;

import java.util.Comparator;
import java.util.Stack;

public class StackOfMethod1 extends AbstractMyStack<Integer>{

    StackOfMethod1() {
        super();
    }

    @Override
    public Integer pop() {

        if (dataStack.isEmpty() || minStack.isEmpty()) {
            throw new RuntimeException("Not support! cause data is empty!");
        }

        Integer pop = dataStack.pop();
        minStack.pop();
        return pop;
    }

    @Override
    public void push(Integer input) {

        dataStack.push(input);

        if (minStack.isEmpty()) {

            minStack.push(input);

        } else {

            Integer currentVal = minStack.peek();
            minStack.push(input > currentVal ? currentVal : input);

        }

    }

    @Override
    public Integer getMin() {
        return minStack.peek();
    }
}
