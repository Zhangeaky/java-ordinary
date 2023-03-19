package com.zhangeaky.se.collections;

public class hashCode {

    public static void main(String[] args) {
        String paymentId = "2o1o88051202209hgd339840320002i2i22";

        int i = paymentId.hashCode();

        System.out.println("hashcode is: "+ i);

        if (i > 0 ){
            System.out.println("Value : " + i);
        }

        if (i < 0 ) {
            System.out.println("Value : " + String.valueOf(i).substring(1));
        }
    }
}
