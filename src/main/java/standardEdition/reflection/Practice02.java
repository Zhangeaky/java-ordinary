package standardEdition.reflection;

class candy {
    candy() {
        System.out.println("constructor ... ");
    }
    static {
        System.out.println("choc loading ... ");
    }
}

public class Practice02 extends candy implements Runnable{

    public static void main(String[] args) throws ClassNotFoundException{
        Class<?> candytype = Class.forName("standardEdition.reflection.candy");
        System.out.println(candytype == Class.forName("standardEdition.reflection.Practice02"));
        System.out.println(candytype.getInterfaces());
    }

    @Override
    public void run() {

    }
}
