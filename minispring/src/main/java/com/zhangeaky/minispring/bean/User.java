package com.zhangeaky.minispring.bean;

public class User {
    public void say() {
        System.out.println("[log] " + this.getClass().getSimpleName());
    }
}
