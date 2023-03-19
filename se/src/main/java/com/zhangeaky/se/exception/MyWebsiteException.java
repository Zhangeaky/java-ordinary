package com.zhangeaky.se.exception;

public class MyWebsiteException extends CommonZhangeakyException{

    MyWebsiteException(String message){
        super(message);
    }


    public static void main(String[] args) throws Exception{

        CommonZhangeakyException e = new MyWebsiteException("send message fail");
        System.out.println(e.getMessage());

    }
}
