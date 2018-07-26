package rxjavaS.impl;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

public class AutoConnectVsRefCount {
    public static void main(String[] args) {
        autoconnectExample();
    }


    /*
    * ConnectableObservable emits items on the first subscription
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

        //Observer 1: 0
        //Observer 1: 1
        //Observer 1: 2
        //Observer 2: 2
        //Observer 1: 3
        //Observer 2: 3
        //Observer 1: 4
        //Observer 2: 4
    }









    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
