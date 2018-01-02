package Concurrency.RvsTEx2;

public class Client {
    public static void main(String[] args) {
        boolean isDeamon = args.length !=0;

        Runnable r = () -> {
            Thread t0 = Thread.currentThread();
            while (true){
                System.out.println(t0.getName());
                System.out.println(t0.isAlive());
                System.out.println(t0.getState());
            }
        };

        Thread t1 = new Thread(r, "t1");


    }
}