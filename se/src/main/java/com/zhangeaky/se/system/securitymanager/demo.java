package com.zhangeaky.se.system.securitymanager;

import org.springframework.aop.ThrowsAdvice;

public class demo {

    public static void main(String[] args) {


        System.setSecurityManager(new SecurityManager());
        SecurityManager securityManager = System.getSecurityManager();
        System.getSecurityManager().checkAccess(Thread.currentThread());

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getName());
        //threadGroup.getMaxPriority()


    }
}
