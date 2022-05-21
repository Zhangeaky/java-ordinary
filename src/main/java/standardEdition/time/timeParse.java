package standardEdition.time;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class timeParse {

    private static ThreadLocal<SimpleDateFormat> tt = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    private static final String TIME = "2020-01-02T22:00:00+08:30";


    private static final FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ssZZ");
    
    
    public static void main(String[] args) throws ParseException {

        Date parse = format.parse(TIME);
        System.out.println(parse);
        System.out.println(format.format(parse));
        Date now = new Date();


        System.out.println(format.format(now));


    }
    
    public static void fun() throws ParseException {
        String stringDate = "2020-01-02 22:00:00";
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date1 = simpleDateFormat.parse(stringDate);
        System.out.println(date1 + ":" + date1.getTime());

        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        Date date2 = simpleDateFormat.parse(stringDate);
        System.out.println(date2 + ":" + date2.getTime());
    }

    public static void timeParse() {
        
        

    }

}
