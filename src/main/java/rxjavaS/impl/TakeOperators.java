package rxjavaS.impl;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class TakeOperators {
    public static void main(String[] args) {
        takeA();
        takeB();
        elAt();
    }



    public static void takeA(){
        Observer<Integer> takeTarget1 = new Observer<Integer>() {
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
        source1.take(3).subscribe(takeTarget1);

        Observable.just(35, 25, 35, 53, 20, 17, 63, 48, 55, 38)
                .take(5)
                .distinct()
                .filter(i -> i >= 18)
                .subscribe(System.out::println);

        Observable.just("a", "b", "c", "d", "e", "f")
                .skip(3)
                .subscribe(System.out::println);
    }

    public static void takeB(){
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS)
                .subscribe(System.out::println);
        sleep(5000);
    }


    public static void takeC(){
        Observable.range(1, 3600)
                .takeWhile(i -> i < 5)
                .subscribe(System.out::println);
    }



    public static void elAt(){
        String[] strArr = {"Alpha", "Beta", "Zeta", "Eta", "Gamma", "Delta"};
        Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma", "Delta")
                .elementAt(strArr.length - 1)
                .subscribe(System.out::println);
    }




    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
