package rxjavaS.impl;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class BasicOperator {
    public static void main(String[] args) {
        takeA();
        takeB();
    }



    public static void takeA(){
        Observer<Integer> target1 = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer i) {
                System.out.println(i*i);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        Observable<Integer> source1 = Observable.just(35, 23, 19, 53, 20, 17, 63, 48, 55, 38);
        source1.take(3).subscribe(target1);

        Observable.just(35, 23, 19, 53, 20, 17, 63, 48, 55, 38)
                .take(3)
                .filter(i -> i >= 18)
                .subscribe(System.out::println);
    }

    public static void takeB(){
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS)
                .subscribe(i -> System.out.println(i));
        sleep(5000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
