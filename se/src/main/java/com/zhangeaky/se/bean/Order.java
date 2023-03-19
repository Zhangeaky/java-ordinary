package com.zhangeaky.se.bean;

public class Order implements Comparable<Order> {

    private final String id;

    private final String status;

    private final Integer content;

    public Order(String id, String status, Integer content) {
        this.id = id;
        this.status = status;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Integer getContent() {
        return content;
    }

    public enum Status {
        SUCCESS,
        INIT,
        PROCESSING,
    }

    @Override
    public int compareTo(Order that) {

        if ("SUCCESS".equals(this.status) && "SUCCESS".equals(that.status)) {
            return this.getContent() - that.getContent();
        }

        if ("SUCCESS".equals(this.status)) {
            return -1;
        }
        if ("SUCCESS".equals(that.status)) {
            return 1;
        }

        return that.getContent() - this.content;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
