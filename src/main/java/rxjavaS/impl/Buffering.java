package rxjavaS.impl;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Buffering {
    public static void main(String[] args) {

    }

    private static void simpleBuffer(){
        Observable.range(1, 20)
                .buffer(6)
                .subscribe(System.out::println);
    }


    /* Buffer emission at each time interval or when count is reached, whichever
    happens first. If the count is reached right before the time window closes, it will result in
    an empty buffer being emitted.*/

    private static void timedBuffer(){
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i +1) * 300)
                .buffer(1, TimeUnit.SECONDS, 2)
                .subscribe(System.out::println);
        sleep(5000);
    }

    //[300, 600]
    //[900]
    //[1200, 1500]
    //[1800]
    //[2100, 2400]
    //[2700]
    //[3000, 3300]
    //[3600, 3900]
    //[]
    //[4200, 4500]
    //[4800]


    private static void boundryBuffer(){
        Observable<Long> boundryIntervals = Observable.interval(1, TimeUnit.SECONDS);
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300) // map to elapsed time
                .buffer(boundryIntervals)
                .subscribe(System.out::println);
        sleep(5000);
    }





    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
