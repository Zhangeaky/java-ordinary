package com.zhangeaky.se.serialize.beans;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: jiegege
 * @Date: 2022/2/12 11:23 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */

@Data
public class employee implements Serializable {

    public employee(String name, String department, long id) {
        this.name = name;
        this.department = department;
        this.id = id;

        System.out.println("Embbed clue ...");
    }

    private String name;
    private String department;
    private long id;
}
