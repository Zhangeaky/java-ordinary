package se.system;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TimeDemo {


    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+8:30'");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        String time = format.format(l);

        System.out.println(time);


    }
}
