package se.serialize.beans;

import java.io.Serializable;

/**
 * @Author: jiegege
 * @Date: 2022/2/13 12:18 上午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class SingletonDoctorStrange implements Serializable {

    public static final SingletonDoctorStrange INSTANCE = new SingletonDoctorStrange("strange");

    private String name;

    private SingletonDoctorStrange(String name) {
        this.name = name;
    }

    protected Object readResolve() {
        return "readResolve from programmer";
    }
}
