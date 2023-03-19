package com.zhangeaky.se.collections;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ArraysTools {

    public static final ParserConfig parseConfig;
    static {
        parseConfig = new ParserConfig();
        parseConfig.setSafeMode(true);
    }

    public static void tool() {

        try {
            String[] aa = new String[]{"ydia", "tongshao"};
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("/Users/kimchang/nihao.text"));
            stream.writeObject(aa);
            stream.close();
        } catch (Exception e) {

        }
    }
    public static void main(String[] args) {

        //tool();


        String value = "[{\"editable\":false,\"name\":\"yida\"}]";
       // Object o = JSONObject.parseObject(value, Array.class, parseConfig);
        //System.out.println(o);

        //JSONObject jsonObject = JSONArray.parseObject(value);
        //System.out.println(jsonObject);
        String substring = value.substring(1, value.length()-1);
        System.out.println(substring);


    }
}
