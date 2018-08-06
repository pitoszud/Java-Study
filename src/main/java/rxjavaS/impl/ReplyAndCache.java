package rxjavaS.impl;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

public class ReplyAndCache {
    public static void main(String[] args) {
        replyExample();
    }

    public static void replyExample(){
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .replay()
                        .autoConnect();

        //Observer 1
        seconds.subscribe(l -> System.out.println("Observer 1: " +
                l));
        sleep(3000);

        //Observer 2
        seconds.subscribe(l -> System.out.println("Observer 2: " + 1));

        sleep(3000);
    }








    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
