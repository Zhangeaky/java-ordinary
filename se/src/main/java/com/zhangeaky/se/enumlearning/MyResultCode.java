package com.zhangeaky.se.enumlearning;

public enum MyResultCode {

    UKNOWN_EXCEPTION("UKNOWN_EXCEPTION", "Throw unknow exception.");

    private String discription;
    private String name;

    MyResultCode(String name, String discription) {
        this.discription = discription;
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public String getName() {
        return name;
    }
}
