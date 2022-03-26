package standardEdition.enumDemo;

/**
 * @Author: jiegege
 * @Date: 2022/2/20 2:48 上午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("I am from " + Country.PRC);

        System.out.println(Country.PRC.hashCode());
        System.out.println(Country.USA.hashCode());
        System.out.println(Country.UK.hashCode());

        System.out.println(Country.UK.getClass());
        System.out.println(Country.PRC.getClass());
        System.out.println(Country.USA.getClass());

    }
}
