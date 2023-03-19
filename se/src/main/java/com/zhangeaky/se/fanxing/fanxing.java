package com.zhangeaky.se.fanxing;


public class fanxing<T> {

    private T job;

    fanxing(T job) {
        this.job = job;
    }

    public T getJob() {
        return job;
    }

    public void setJob(T job) {
        this.job = job;
    }
}
