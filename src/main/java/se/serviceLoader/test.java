package se.serviceLoader;

import java.util.ResourceBundle;
import java.util.ServiceLoader;

/**
 * @Author: jiegege
 * @Date: 2022/2/20 1:50 上午
 * @address: hangzhou
 * @description:
 *      1. 测试 spi
 *
 * @Version 1.0
 */
public class test {

    public static void main(String[] args) {

        System.out.println("begin ... ");

        ResourceBundle bundle = ResourceBundle.getBundle("example");

        String user = bundle.getString("user");
        System.out.println(user);

        ServiceLoader<person> loader = ServiceLoader.load(person.class);

        for (person person : loader) {

            person.introduce();
        }


    }
}
