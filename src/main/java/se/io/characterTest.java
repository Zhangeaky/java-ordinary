package se.io;

import java.io.*;
import java.util.Date;

/**
 * @Author: jiegege
 * @Date: 2022/1/25 2:31 δΈε
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class characterTest {

    static void tryWithOutPutStream () throws Exception {
        OutputStream outputStream = new FileOutputStream("./zhangeaky.txt");
        outputStream.write(9789879);
        outputStream.flush();
        outputStream.close();
    }

    static void tryWithFilterOutPutStream() throws FileNotFoundException {

    }

    static void tryWithObjectStream() throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("zhangeky.txt")));
        outputStream.writeObject(new Date());
        outputStream.flush();

    }

    static void tryWithCommandLineInterAction() throws IOException {

        System.out.println("ζ");
        //int read = System.in.read();
        InputStreamReader reader = new InputStreamReader(System.in);
        DataOutputStream outputStream = new DataOutputStream(System.out);
        //outputStream.writeChars(reader);

    }

    static void tryWithData() throws FileNotFoundException {

    }

    public static void main(String[] args) {

        try {
            //tryWithCommandLineInterAction();
            //tryWithObjectStream();
            tryWithData();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
