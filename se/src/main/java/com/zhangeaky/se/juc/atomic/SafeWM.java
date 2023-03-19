package com.zhangeaky.se.juc.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class SafeWM {

    /**
     * 库存范围
     */
    class WMRange {
        final int upper;
        final int lower;

        public WMRange(int upper, int lower) {
            this.upper = upper;
            this.lower = lower;
        }
    }

    final AtomicReference<WMRange> rf = new AtomicReference<>(new WMRange(0, 0));

    void setUpper(int upper) {

        WMRange nr;
        WMRange or = rf.get();

        do {
            if (upper < or.lower) {
                throw new IllegalArgumentException();
            }
            System.out.println(" to set");
            // 设置新的上界
            nr = new WMRange(upper, or.lower);

        } while (!rf.compareAndSet(or, nr));

    }

    public static void main(String[] args) {
        SafeWM mm = new SafeWM();

        mm.setUpper(10);
    }
}
