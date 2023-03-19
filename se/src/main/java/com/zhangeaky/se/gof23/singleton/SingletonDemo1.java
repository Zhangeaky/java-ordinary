package com.zhangeaky.se.gof23.singleton;

public class SingletonDemo1 implements Runnable{


    public static void main(String[] args) {


        while (true) {
            new Thread(new SingletonDemo1()).start();
        }



    }

    @Override
    public void run() {
        int i = IdGenerator.getInstance().generateId();
        System.out.println("idGenerator is :" + IdGenerator.getInstance() + " id is: " + i);
    }
}
