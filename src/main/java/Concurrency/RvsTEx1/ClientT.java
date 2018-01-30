package Concurrency.RvsTEx1;

public class ClientT {
    public static void main(String[] args) {
        RandomGenerator tgen = new RandomGenerator();

        T1 t1 = new T1(tgen);
        T1 t2 = new T1(tgen);
        T1 t3 = new T1(tgen);
        T1 t4 = new T1(tgen);
        T1 t5 = new T1(tgen);
        T1 t6 = new T1(tgen);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}