package Concurrency.RvsTEx2;

public class Join {

/*
* join() can be used to run threads in particular order
*
* */

    public static void main(String[] args) {
        boolean isDeamon = args.length !=0;

        Runnable r = () -> {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 5; i++) {
                System.out.println(name + ": " + i + " - " + Thread.currentThread().getState());
                try {
                    System.out.println(name + " SLEEP");
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    System.out.println(name + " interrupted");
                }
            }
        };

        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");
        Thread t3 = new Thread(r, "t3");

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // t2 starts once t1 has finished running
        t2.start();


        try {
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // t3 starts once t2 has finished running
        t3.start();

        try {
            t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // println() starts once t3 has finished running
        System.out.println("all threads finished running in sequence");

    }

}