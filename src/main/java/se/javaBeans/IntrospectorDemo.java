package se.javaBeans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Arrays;

/**
 * @Author: jiegege
 * @Date: 2022/2/10 6:57 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */

public class IntrospectorDemo {


    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(person.class);
        System.out.println(Arrays.toString(beanInfo.getPropertyDescriptors()));
    }
}
