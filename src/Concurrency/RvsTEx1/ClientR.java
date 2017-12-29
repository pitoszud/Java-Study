package Concurrency.RvsTEx1;

public class ClientR {
    public static void main(String[] args) {
        RandomGenerator tgen = new RandomGenerator();

        R1 r1 = new R1(tgen);
        Thread t1 = new Thread(r1);

        R1 r2 = new R1(tgen);
        Thread t2 = new Thread(r2);

        R1 r3 = new R1(tgen);
        Thread t3 = new Thread(r3);


        R1 r4 = new R1(tgen);
        Thread t4 = new Thread(r4);

        R1 r5 = new R1(tgen);
        new Thread(r5).start();  // anonymous thread

        R1 r6 = new R1(tgen);
        new Thread(r6).start();  // anonymous thread

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}