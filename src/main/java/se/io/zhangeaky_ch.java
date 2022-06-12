package se.io;

import java.util.ListResourceBundle;

/**
 * @Author: jiegege
 * @Date: 2022/1/31 5:29 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class zhangeaky_ch extends ListResourceBundle {


    private final Object[][] contents = new Object[][] {

            {"name", "zhangeaky"},
            {"age", 26}

    };


    /**
     * Returns an array in which each item is a pair of objects in an
     * <code>Object</code> array. The first element of each pair is
     * the key, which must be a <code>String</code>, and the second
     * element is the value associated with that key.  See the class
     * description for details.
     *
     * @return an array of an <code>Object</code> array representing a
     * key-value pair.
     */
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
