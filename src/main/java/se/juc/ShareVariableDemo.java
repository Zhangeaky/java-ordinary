package se.juc;

public class ShareVariableDemo {

    public void test01() {

         int[] i = {0};

        Runnable rr = new Runnable() {
            @Override
            public void run() {
                i[0] +=1;
            }
        };

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                i[0] +=1;
            }



    });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                i[0] +=1;
            }

    });

        for(int j=0; j<1000; j++) {
            new Thread(rr).start();
        }


        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (Exception e) {
            System.out.println("!");
        }

        System.out.println(i[0]);

        while (true);



    }

    public static void main(String[] args) {

        ShareVariableDemo svd = new ShareVariableDemo();
        svd.test01();




    }
}

class tt {


    static class share {
        private Integer a;

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {

        //Operati


    }


}
