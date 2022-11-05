package se.bean.javabean;


import java.math.BigDecimal;

public class Apple extends Fruit{

    public Apple(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    private String name;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
