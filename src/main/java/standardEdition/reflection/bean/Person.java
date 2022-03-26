package standardEdition.reflection.bean;

public class Person {

    private String name = "zhang";
    private Integer age = 18;

    public Person() {
        System.out.println("无参构造方法...");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
