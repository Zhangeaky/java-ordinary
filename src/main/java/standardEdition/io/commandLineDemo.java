package standardEdition.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: jiegege
 * @Date: 2022/1/25 4:45 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class commandLineDemo {

    public static void main(String[] args) {
        InputStream in = System.in;
        try {

            System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
