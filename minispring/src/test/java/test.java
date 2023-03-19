import com.zhangeaky.minispring.ClassPathXmlApplicationContext;
import com.zhangeaky.minispring.bean.User;

public class test {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/bean.xml");
        Object user = context.getBean("user");
        User bean = (User) user;
        bean.say();
    }
}
