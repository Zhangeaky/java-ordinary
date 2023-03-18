import com.zhangeaky.rpc.dto.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test {

    static void test01() {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(
                    new File("/Users/kimchang/IdeaProjects/javaSELearning/User"));
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(new User());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test01();
    }
}
