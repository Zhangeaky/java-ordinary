package commontools.alibaba;

import bean.javabean.Apple;
import bean.javabean.Fruit;
import bean.tmp;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: jiegege
 * @Date: 2022/3/20 7:37 PM
 * @address: hangzhou
 * @description: 入门使用 fastJson https://blog.csdn.net/wangmx1993328/article/details/80882745
 *
 *          一、JSON 抽象类
 *              toJSONString();
 *          二、JsonObject
 *
 * @Version 1.0
 */
public class FastJsonDemo {

    static class Model{

        public Model(String serial, Fruit fruit) {
            this.serial = serial;
            this.fruit = fruit;
        }

        private String serial;
        private Fruit fruit;

        public String getSerial() {
            return serial;
        }

        public void setSerial(String serial) {
            this.serial = serial;
        }

        public Fruit getFruit() {
            return fruit;
        }

        public void setFruit(Fruit fruit) {
            this.fruit = fruit;
        }
    }

    /**
     * JSON.XXXX
     */
    public static void JSONTest() {

        Apple apple = new Apple("hongfushi ", new BigDecimal(0.3));

        String appleJson = JSON.toJSONString(apple);

        System.out.println("[appleJson]: " + appleJson);

        Model model = new Model("1500", apple);
        String modelJson = JSON.toJSONString(model);
        System.out.println("[modelJson]: " + modelJson);

        Model mm = JSON.parseObject(modelJson, Model.class);
        System.out.println(mm);


    }

    //按照JSON格式输出map字符串
    public static void test() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "One");
        map.put("key2", "Two");
        String mapJson = JSON.toJSONString(map);
        System.out.println(mapJson);
        //输出：{"key1":"One","key2":"Two"}

        tmp zhangyikai = new tmp();
        zhangyikai.setId("328153");
        zhangyikai.setName("yida");

        tmp jackma = new tmp();
        jackma.setId("000001");
        jackma.setName("fengqingyang");

        List<tmp> perssonList = Arrays.asList(zhangyikai,jackma);
        String personListJson = JSON.toJSONString(perssonList);
        System.out.println("person list json" + personListJson);
    }

    public static void test2() {

        String jsonStr = "{\"key1\": {\"name\":\"zhangeaky\",\"id\":\"18\"},\"key2\":\"110\"}";
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        tmp key1 = jsonObject.getObject("key1", tmp.class);
        System.out.println(key1);
        System.out.println(jsonObject.getString("key1"));//输出one
        System.out.println(jsonObject.getInteger("key2"));//输出110

        String jsonString = jsonObject.toJSONString();
        System.out.println("将object 转化为string"+ jsonString);

    }

    public static void testSet() {

        String jsonStr = "{\"key1\": {\"name\":\"zhangeaky\",\"id\":\"18\"},\"key2\":\"110\"}";
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        JSONPath.set(jsonObject,"$key2","22");
        System.out.println(jsonObject.toJSONString());

    }

    public static void main(String[] args) {

        //test();
        //test2();
        //testSet();
        JSONTest();

    }
    //
}
