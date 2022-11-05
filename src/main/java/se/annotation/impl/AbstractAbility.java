package se.annotation.impl;

import se.annotation.Ability;
import se.annotation.Zhangeaky;

@Zhangeaky
public abstract class AbstractAbility implements Ability {

    @Zhangeaky
    private String name;

    @Zhangeaky
    protected void testAnnotation() {}
}
