package standardEdition.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author: jiegege
 * @Date: 2022/3/20 3:44 PM
 * @address: hangzhou
 * @description:  1. 要求知道什么是检查型异常
 *                2. java 7 对try catch 处理多个异常的升级写法。
 *                3.* 异常包装抛出。
 *                4. try-with-resources
 * @Version 1.0
 */
public class demo {

    static class zhangeakyException extends Exception{
        zhangeakyException(){}
        zhangeakyException(String message){
            super(message);
        }
    }

    static class yidaException extends Exception{
        yidaException(String message){
            super(message);
        }
    }

    public static void throwsDemo(int index) throws zhangeakyException, yidaException {

        if (index == 0) {
            throw new yidaException("This is a yidaException demo");
        }
        throw new zhangeakyException("This is a zhangeakyException demo .");
    }

    public static void encapsulateException() throws Exception{

        try{
            throwsDemo(1);
        }catch (yidaException | zhangeakyException e) {
            Exception ex = new Exception("self define exception");
            e.initCause(ex);
            throw ex;
        }

    }

    public static int tryFinally(int[] input) {

        try{
            return input[5];
        }finally {
            return 100;
        }
    }

    public static void tryWithResources() throws FileNotFoundException {

        FileInputStream inputStream = new FileInputStream("bean.txt");



    }

    public static void main(String[] args){

        //int i = tryFinally(new int[]{1, 2});
        //System.out.println(i);
        try {
            throwsDemo(0);

        }catch (Exception e){
            System.out.println(e);
        }


    }


}
