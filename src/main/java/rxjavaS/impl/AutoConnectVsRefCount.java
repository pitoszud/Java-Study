package rxjavaS.impl;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

public class AutoConnectVsRefCount {
    public static void main(String[] args) {
        autoconnectExample();
        refCountExample();
    }


    /*
    * For a given ConnectableObservable<T>, calling autoConnect() will return an
    Observable<T> that will automatically call connect() after a specified number of
    Observers are subscribed.
    */

    public static void autoconnectExample(){
        Observable<Long> seconds = Observable
                .interval(1, TimeUnit.SECONDS)
                .publish()
                .autoConnect(1);

        //Observer 1
        seconds.subscribe(i -> System.out.println("Observer 1: " + i));
        sleep(3000);

        //Observer 2
        seconds.subscribe(i -> System.out.println("Observer 2: " + i));
        sleep(3000);


        System.out.println("-----------------------");

        //Observer 1: 0
        //Observer 1: 1
        //Observer 1: 2
        //Observer 2: 2
        //Observer 1: 3
        //Observer 2: 3
        //Observer 1: 4
        //Observer 2: 4
    }


    /*
    The refCount() operator on ConnectableObservable is similar to
    autoConnect(1), which fires after getting one subscription. But there is one important
    difference; when it has no Observers anymore, it will dispose of itself and start over when a
    new one comes in. It does not persist the subscription to the source when it has no more
    Observers, and when another Observer follows, it will essentially "start over".
    */

    public static void refCountExample(){
        Observable<Long> secs = Observable
                .interval(1, TimeUnit.SECONDS)
                .publish()
                .refCount();

        //Observer 1
        secs.take(5).subscribe(l -> System.out.println("Observer 1: " + l));

        sleep(3000);

        //Observer 2
        secs.take(2).subscribe(l -> System.out.println("Observer 2: " + l));

        sleep(3000);

        //Observer 3
        secs.subscribe(l -> System.out.println("Observer 3: " + l));


        //Observer 1: 5
        //Observer 2: 5
        //Observer 1: 6
        //Observer 2: 6
        //Observer 1: 0
        //Observer 1: 7
        //Observer 2: 7
        //Observer 1: 1
        //Observer 1: 8
        //Observer 2: 8
        //Observer 1: 2
        //Observer 1: 9
        //Observer 2: 9
        //Observer 1: 3
        //Observer 2: 3
        //Observer 1: 10
        //Observer 2: 10
        //Observer 1: 4
        //Observer 2: 4
        //Observer 1: 11
        //Observer 2: 11
    }







    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
