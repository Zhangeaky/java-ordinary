package se.jvm.classFile;

import java.util.ArrayList;

/**
 * @Author: jiegege
 * @Date: 2022/1/2 7:36 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class zhangEaky extends ArrayList implements Runnable {

    private String name;
    private int age;
    boolean sex;

    @Override
    public void run() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

    }
}

class demo {

    private void run() {}

}
