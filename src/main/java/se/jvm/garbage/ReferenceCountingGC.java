package se.jvm.garbage;

/**
 * @Author: jiegege
 * @Date: 2022/1/22 12:02 上午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024*1024;

    private byte[] bigSize = new byte[2* _1MB];

    public static void testGC() {
        ReferenceCountingGC aa = new ReferenceCountingGC();
        ReferenceCountingGC bb = new ReferenceCountingGC();

        aa.instance = bb;
        bb.instance = aa;

        System.out.println(aa);
        System.out.println(bb);


        bb = null;
        System.out.println(aa.instance);
        System.out.println(bb.instance);





        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
