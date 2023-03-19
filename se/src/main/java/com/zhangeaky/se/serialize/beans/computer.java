package com.zhangeaky.se.serialize.beans;

import java.io.Serializable;

/**
 * @Author: jiegege
 * @Date: 2022/2/15 11:04 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class computer implements Serializable {
    private String brand;
    private String owner;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
