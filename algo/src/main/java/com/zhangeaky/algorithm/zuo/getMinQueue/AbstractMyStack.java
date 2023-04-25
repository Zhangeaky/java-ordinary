package com.zhangeaky.algorithm.zuo.getMinQueue;

import java.util.Stack;

public abstract class AbstractMyStack<T> implements MyStack<T>{

    AbstractMyStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    protected Stack<T> dataStack;

    protected Stack<T> minStack;

}
