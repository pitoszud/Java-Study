package Concurrency.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fixed {
    public static void main(String[] args) {
        ExecutorService es1 = Executors.newFixedThreadPool(3);
        es1.execute(new FixedRA());
        es1.execute(new FixedRA());
        es1.execute(new FixedRA());
        es1.shutdown();

        ExecutorService es2 = Executors.newCachedThreadPool();
        es2.execute(new FixedRA());
        es2.execute(new FixedRA());
        es2.execute(new FixedRA());
        es2.shutdown();

        ExecutorService es3 = Executors.newSingleThreadExecutor();
        es3.execute(new FixedRA()); // this will run first
        es3.execute(new FixedRA()); // this will run second
        es3.execute(new FixedRA()); // this will run third
        es3.shutdown();
    }
}
