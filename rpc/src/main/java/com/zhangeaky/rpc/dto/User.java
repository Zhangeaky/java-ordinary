package com.zhangeaky.rpc.dto;

import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {

    String name;

    String id;

    private void writeObject(ObjectOutputStream objectOutputStream) {
        System.out.println("序列化过程 。。。");

    }
}
