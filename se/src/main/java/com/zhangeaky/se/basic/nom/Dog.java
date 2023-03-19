package com.zhangeaky.se.basic.nom;

public class Dog extends Animal{
    @Override
    void say() {
        System.out.println("wof! wof!");
    }

    public void test() {
        Dog.this.say();
        //say();
    }
}


class test_01 {
    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.say();



    }
}
