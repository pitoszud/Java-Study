package rxjavaS.impl;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class RapidClicks {
    public static void main(String[] args) {
        //throttleSimple();
        System.out.println("---------------");
        throttleLastExample();
        System.out.println("----------------");
        //throttleLastWithTimeoutExample();
    }


    public static void throttleLastExample(){
        // 10 emmisions per second - let's select only two
        Observable<String> s1 = Observable.interval(250, TimeUnit.MILLISECONDS)
                .map(i -> (i+1) * 250)
                .map(i -> "SOURCE 1: " + i)
                .take(2);


        Observable<String> s2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i+1) * 300)
                .map(i -> "SOURCE 2: " + i)
                .take(3);

        Observable<String> s3 = Observable.interval(2000, TimeUnit.MILLISECONDS)
                .map(i -> (i+1) * 2000)
                .map(i -> "SOURCE 3: " + i)
                .take(2);

        Observable.concat(s1, s2, s3)
                .throttleLast(1000, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        // s1 0__2.5             |
        // s2 0______3______9____|__12
        // s3 0__________________|_____________________20

        // SOURCE 2: 300
        // SOURCE 2: 900
        // SOURCE 3: 2000

        // the line indicates which intervals up to an interval that is crossed are being observed

        sleep(6000);

    }



    public static void throttleLastWithTimeoutExample(){
        Observable<String> source1 = Observable.interval(100,
                TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 100) // map to elapsed time
                .map(i -> "SOURCE 1: " + i)
                .take(10);

        Observable<String> source2 = Observable.interval(300,
                TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300) // map to elapsed time
                .map(i -> "SOURCE 2: " + i)
                .take(3);

        Observable<String> source3 = Observable.interval(2000,
                TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 2000) // map to elapsed time
                .map(i -> "SOURCE 3: " + i)
                .take(2);

        Observable.concat(source1, source2, source3)
                .throttleWithTimeout(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        // s1 0_1             |
        // s2 0___3___6___9___|__12
        // s3 0_____________10|_________20_________30

        // the line indicates which intervals are being observed:
        // SOURCE 2: 900
        // SOURCE 3: 2000
        // SOURCE 3: 4000

        sleep(6000);

    }




    public static void throttleSimple(){
        // 10 emmisions per second - let's select only two
        Observable<String> source1 = Observable.interval(100, TimeUnit.MILLISECONDS)
                .map(i -> (i+1) * 100)
                .map(i -> "SOURCE 1: " + i)
                .take(2);


        Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i+1) * 300)
                .map(i -> "SOURCE 2: " + i)
                .take(3);

        Observable<String> source3 = Observable.interval(2000, TimeUnit.MILLISECONDS)
                .map(i -> (i+1) * 2000)
                .map(i -> "SOURCE 3: " + i)
                .take(2);

        Observable.concat(source1, source2, source3)
                .subscribe(System.out::println);

        sleep(6000);

    }


    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
