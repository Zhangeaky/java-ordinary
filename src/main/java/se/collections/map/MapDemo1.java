package se.collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {
    public static void main(String[] args) {

        Map<String, String> people = new HashMap<>();

        Map<String, String> ren = new HashMap<>();
        ren.put("name", "yida");
        ren.put("id", "328153");
        people.putAll(ren);

        for (Map.Entry entry : people.entrySet()) {
            String a = (String) entry.getKey() +  entry.getValue();
            System.out.println(a);
        }








    }
}
