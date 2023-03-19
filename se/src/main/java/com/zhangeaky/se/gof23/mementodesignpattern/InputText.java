package com.zhangeaky.se.gof23.mementodesignpattern;

public class InputText {

    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String inupt) {
        text.append(inupt);
    }

}
