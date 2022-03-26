import common.Calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class AddTest {

    @Test
    public void addTest() {

        Calculator cal = new Calculator();
        int add = cal.add(10, 10);
        System.out.println("result " + add);

    }

    @Test
    public void addTest1() {

        Calculator cal = new Calculator();
        int add = cal.add(10, 10);
        assertEquals(add, 10, 0);
        System.out.println("result1 " + add);

    }
}
