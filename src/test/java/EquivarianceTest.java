import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EquivarianceTest {

    private int one;
    private int two;
    private int three;

    @Parameterized.Parameters
    public static Collection<Integer []> getCollection() {

        return Arrays.asList(new Integer[][] {
                {1,2,3},{1,3,5},{3,9,27}
        });
    }

    public EquivarianceTest(int one, int two, int three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    @Test
    public void OneTest() {

        assertEquals(two - one, three - two);

    }
}
