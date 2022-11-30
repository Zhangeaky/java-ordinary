package se.java8.bean;

import java.util.List;

public class BasketBallPlayer implements Comparable<BasketBallPlayer>{

    private String name;
    private Double pts;
    private Double rebs;
    private Double ast;
    private POSITION position;
    private String number;
    private List<String> hornors;

    public List<String> getHornors() {
        return hornors;
    }

    public void setHornors(List<String> hornors) {
        this.hornors = hornors;
    }

    public BasketBallPlayer(String name, Double pts, Double rebs, Double ast, POSITION position, String number) {
        this.name = name;
        this.pts = pts;
        this.rebs = rebs;
        this.ast = ast;
        this.position =position;
        this.number = number;
    }

    public POSITION getPosition() {
        return position;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Double getPts() {
        return pts;
    }

    public Double getRebs() {
        return rebs;
    }

    public Double getAst() {
        return ast;
    }

    @Override
    public String toString() {
        return "BasketBallPlayer{" +
                "name='" + name + '\'' +
                ", pts=" + pts +
                ", rebs=" + rebs +
                ", ast=" + ast +
                '}';
    }

    public enum POSITION{
        POINT_GUARD,
        SHOTTING_GUARD,
        CENTER,
        POWER_FORWARD,
        SCORE_FORWARD
    }

    @Override
    public int compareTo(BasketBallPlayer o) {
        if ((this.getPts() - o.getPts()) > 0) {
            return 1;
        } else if ((this.getPts() - o.getPts()) < 0) {
            return -1;
        } else {
            return 0;
        }

    }
}
