package com.zhangeaky.se.jvm.garbage;

/**
 * @Author: jiegege
 * @Date: 2022/1/22 12:29 上午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class FinalizeEscape {

    public static FinalizeEscape SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("Yes, I am alive ...");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize method executing...");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscape();

        SAVE_HOOK = null;

        System.gc();

        Thread.sleep(500);

        if (SAVE_HOOK != null) {
            System.out.println(SAVE_HOOK);
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("I am dead ... ");
        }

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no I am dead ..");
            SAVE_HOOK.isAlive();
        }
    }
}
