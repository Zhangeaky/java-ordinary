package se.serialize;
import java.io.*;
import se.serialize.beans.computerRetailer;
import se.serialize.beans.computer;

/**
 *
 * @Author: jiegege
 * @Date: 2022/2/15 11:03 下午
 * @address: hangzhou
 * @description:
 *     1。 一个被序列化的类 其成员类也要实现serialize 接口
 * @Version 1.0
 *
 */
public class MuiltiSerializeDemo implements Serializable{
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        computer computer = new computer();
        computer.setBrand("apple");
        computer.setOwner("zhangeaky");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("bean.txt"));

        computerRetailer retailer = new computerRetailer();
        retailer.setLocate("china");
        retailer.setComputer(computer);

        out.writeObject(retailer);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("bean.txt"));

        Object o = in.readObject();
        System.out.println(o);
        computerRetailer rr =  (computerRetailer)o;

    }
}
