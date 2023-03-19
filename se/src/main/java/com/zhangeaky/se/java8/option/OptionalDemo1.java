package com.zhangeaky.se.java8.option;

import org.apache.commons.lang3.BooleanUtils;
import com.zhangeaky.se.java8.bean.BasketBallPlayer;
import com.zhangeaky.se.java8.stream.StreamDemo3;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalDemo1 {

    static class BizOrder {
        Integer isFreeze;

        public Integer getIsFreeze() {
            return isFreeze;
        }


        public void setIsFreeze(Integer isFreeze) {
            this.isFreeze = isFreeze;
        }

        @Override
        public String toString() {
            return "BizOrder{" +
                    "isFreeze=" + isFreeze +
                    '}';
        }
    }

    static class TradeBillDetail {

        boolean freeze;

        public boolean isFreeze() {
            return freeze;
        }

        public void setFreeze(boolean freeze) {
            this.freeze = freeze;
        }

        @Override
        public String toString() {
            return "TradeBillDetail{" +
                    "freeze=" + freeze +
                    '}';
        }
    }

    public static void BizOrder2DetailTest() {

        BizOrder bizOrder = new BizOrder();

        TradeBillDetail detail = new TradeBillDetail();

        detail.setFreeze(BooleanUtils.toBoolean(Optional.ofNullable(bizOrder.getIsFreeze()).orElse(0)));

        System.out.println(bizOrder);
        System.out.println(detail);
    }

    static class Car {


    }


    static class Person {

        private Car car;

        public Car getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = car;
        }
    }

    public static void createOptional() {

        // 第一种
        Optional<Person> personal = Optional.empty();

        try {

            // 第二种
            Optional<Person> personFirst = Optional.of(null);
            Optional<Car> car = Optional.ofNullable(personFirst.map(Person::getCar).orElseThrow(() -> {
                return new RuntimeException();
            }));



        }catch (Exception e) {
            System.out.println("这里会抛出异常 。。。");
        }

        Optional<Car> opCar = Optional.ofNullable(new Car());

        Person person = new Person();

        Optional<Car> car = Optional.ofNullable(person).map(Person::getCar);
        System.out.println(car);
    }

    public static void OptionalMemberFunction(String name) {

        Map<String, String> playerMap = StreamDemo3.players.stream().collect(Collectors.toMap(BasketBallPlayer::getName, BasketBallPlayer::getNumber));

        String niaho = Optional.ofNullable(playerMap.get(name))
                .orElseGet(() -> {
                    return StreamDemo3.players.get(0).getName();
                });
        System.out.println(niaho);
//
//        Optional.ofNullable(playerMap.get("ni"))
//                .orElse()

    }

    public static void main(String[] args) throws IOException {
        //createOptional();
//        int name = System.in.read();
//        System.out.println("[raw name]: " + name);
//        OptionalMemberFunction(String.valueOf(name));


        BizOrder2DetailTest();
    }



}
