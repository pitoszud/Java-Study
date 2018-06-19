package rxjavaS.impl;

import io.reactivex.Observable;

public class DoOn {
    public static void main(String[] args) {
        doOn();
    }

    public static void doOn() {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doOnNext(System.out::println)
                .map(String::length)
                .subscribe(System.out::println);

        Observable.just(1,2,3,4,5,0,6,7,8)
                .map(i -> 1.25/i)
                .doOnComplete(System.out::println)
                .doOnError(System.out::println)
                .subscribe(System.out::println);

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doOnSubscribe(d -> System.out.println("Subscribing!"))
                .doOnDispose(() -> System.out.println("Disposing!"))
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
