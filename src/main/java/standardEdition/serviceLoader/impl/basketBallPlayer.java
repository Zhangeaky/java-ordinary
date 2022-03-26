package standardEdition.serviceLoader.impl;

import standardEdition.serviceLoader.person;

/**
 * @Author: jiegege
 * @Date: 2022/2/20 1:47 上午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class basketBallPlayer implements person {

    @Override
    public void sayHey() {

        System.out.println("I play basketball ... ");

    }

    @Override
    public void introduce() {

        System.out.println("my name is Micheal Jordan ... ");

    }
}
