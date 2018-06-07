package rxjavaS.impl;

import io.reactivex.Observable;

public class ReduceAndCollections {
    public static void main(String[] args) {
        reduceOps();
    }

    public static void reduceOps() {
        Observable.just("one", "two", "three", "four", "five", "six", "seven", "eight")
                .map(String::length)
                .reduce((total, next) -> total + next)
                .subscribe(System.out::println);

        Observable.just(15,27,33,47,59,64,72,84,93)
                .all(i -> i <= 100)
                .subscribe(System.out::println);

        Observable.just(15,27,33,47,59,64,72,84,93)
                .any(i -> i <= 100)
                .subscribe(System.out::println);
    }

    public static void colsOps(){
        Observable.just("one", "two", "three", "four", "five", "six", "seven", "eight")
                .toList()
                .subscribe(System.out::println);

        Observable.just("one", "two", "three", "four", "five", "six", "seven", "eight")
                .toSortedList()
                .subscribe(System.out::println);
    }



}
