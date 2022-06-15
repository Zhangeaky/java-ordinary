package se.serialize;

import java.io.*;
import java.util.Random;

class Data implements Serializable{

    private int n;
    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Data{" +
                "n=" + n +
                '}';
    }
}
public class day1 implements Serializable{

    private static Random rand = new Random(47);
    private Data[] d ={
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))

    };

    private day1 next;
    private char c;

    public day1(int i, char x) {
        System.out.println("day 1 constructor " + i);
        this.c = x;
        if(--i>0)
            next = new day1(i, (char)(x+1));

    }
    day1() {
        System.out.println("Default constructor");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data data : d) {
            result.append(d);
        }
        result.append(")");
        if (next != null) {
            result.append(next);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        day1 day1 = new day1(6, 'a');
        System.out.println("day1 = "+ day1);
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("day1.out")
        );
        out.writeObject("day1 storage");
        out.writeObject(day1);
        out.close();

        ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("day1.out")
        );
        String s = (String) input.readObject();
        day1 day11 = (day1) input.readObject();
        System.out.println(s+"day11= "+day11);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("day2 storage");
        out2.writeObject(day1);
        out2.flush();


    }

}
