package com.zhangeaky.se.annotation.impl;

import com.zhangeaky.se.annotation.Ability;
import com.zhangeaky.se.annotation.Zhangeaky;

@Zhangeaky
public abstract class AbstractAbility implements Ability {

    @Zhangeaky
    private String name;

    @Zhangeaky
    protected void testAnnotation() {}
}
