package standardEdition.io;

import java.io.*;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @Author: jiegege
 * @Date: 2022/1/27 2:10 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class ResourceDemo {


    static class ResourceBundleTest {

        public static void main(String[] args) {

            String baseName = "zhangeaky";

            ResourceBundle bundle = ResourceBundle.getBundle(baseName, Locale.CHINA);

            System.out.println(bundle.keySet());
            System.out.println(bundle.getBaseBundleName());
            System.out.println(bundle.getString("name"));

            ResourceBundle bundle1 = ResourceBundle.getBundle(baseName, Locale.JAPAN);

            System.out.println(bundle1.getString("time"));


        }

    }



    public static void main(String[] args) throws IOException {

        String path = "file:/Users/kimchang/a.c";
        URL url = new URL(path);
        String getPath = url.getPath();
        String host = url.getHost();
        Object content = url.getContent();
        System.out.println(getPath);
        System.out.printf("host is %s \n", host);
       // System.out.println("content " + content.);





    }

    static class test {

        public static void main(String[] args) throws IOException {
            Properties properties = System.getProperties();

           properties.store(new FileWriter("properties.txt"), "keyi");

           FileWriter writer = new FileWriter("tmp.txt");
           writer.write("张毅凯。。。。。。。。。。。");
           writer.write("asdfghjkl", 0,3);
           //writer.flush();
           writer.close();

            FileReader reader = new FileReader("tmp.txt");
            //URL
            System.out.println(reader.read());

        }
    }
}
