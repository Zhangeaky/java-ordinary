package se.serialize.beans;

import java.io.Serializable;

/**
 * @Author: jiegege
 * @Date: 2022/2/15 11:06 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class computerRetailer implements Serializable {

    private se.serialize.beans.computer computer;
    private String locate;

    public se.serialize.beans.computer getComputer() {
        return computer;
    }

    public void setComputer(se.serialize.beans.computer computer) {
        this.computer = computer;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    @Override
    public String toString() {
        return "computerRetailer{" +
                "computer=" + computer.getBrand() + " " +computer.getOwner() +
                ", locate='" + locate + '\'' +
                '}';
    }
}
