package com.zhangeaky.se.javaBeans;

import lombok.Data;

/**
 * @Author: jiegege
 * @Date: 2022/2/10 7:02 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */

@Data
public class person {
    static {
        System.out.println("[实例化] ... ");
    }
    private String name;
    private Integer age;
}
