package Concurrency.Executors;

import java.util.concurrent.TimeUnit;

public class FixedRA implements Runnable {
    private static int count = 0;
    private int id;

    public FixedRA(){
        id = count++;
    }


    @Override
    public void run() {
        System.out.println(id + " started");
        for (int i = 10; i > 0; i--) {
            System.out.println(i + " cyk");
            try{
                TimeUnit.MICROSECONDS.sleep((long)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(id + " done");
    }
}
