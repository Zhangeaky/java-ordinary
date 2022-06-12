package se.collections;

public class mapdemo {

    public static void hash(String input) {
        System.out.println(input.hashCode());
    }

    public static void main(String[] args) {
        String paymentId = "2188202205142022EDF339840322222221";

        String paymentId2 = "2188202205142022339840322222221";

        int h = paymentId.hashCode();

        int index = h ^ (h >>> 16);
        System.out.println("hash index:" + index);
        System.out.println(paymentId2.hashCode());
        System.out.println(paymentId.hashCode());
    }
}
