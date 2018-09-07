package rxjavaS.impl;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Backlogged {

    public static void main(String[] args) {
        //backpressure();
        backpressureWithFlowable();
    }


    private static void backpressure(){
        Observable.range(1, 999_999)
                .map(MyItem::new)
                .observeOn(Schedulers.io())
                .subscribe(myItem -> {
                    sleep(50);
                    System.out.println("Received MyItem " +
                            myItem.id);
                });
        sleep(Long.MAX_VALUE);
    }

    // ...
    // Constructing MyItem 999997
    // Constructing MyItem 999998
    // Constructing MyItem 999999
    // Received MyItem 92
    // Received MyItem 93
    // Received MyItem 94
    // ...



    // Flowables subscribe with Subscribers instead of Observers
    // emissions and subscriptions are pipelined more ore less evenly:
    // an extra cache between emitting and consuming is added (417-384 = 33) for a possible idle time.
    private static void backpressureWithFlowable(){
        Flowable.range(1, 999_999)
                .map(MyItem::new)
                .observeOn(Schedulers.io())
                .subscribe(myItem -> {
                    sleep(50);
                    System.out.println("Received MyItem " +
                            myItem.id);
                });
        sleep(Long.MAX_VALUE);
    }

    // ...
    // Constructing MyItem 414
    // Constructing MyItem 415
    // Constructing MyItem 416
    // Received MyItem 289
    // Received MyItem 290
    // Received MyItem 291
    // ...
    // Received MyItem 382
    // Received MyItem 383
    // Received MyItem 384
    // Constructing MyItem 417
    // ...




    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    static final class MyItem {
        final int id;
        MyItem(int id) {
            this.id = id;
            System.out.println("Constructing MyItem " + id);
        }
    }
}
