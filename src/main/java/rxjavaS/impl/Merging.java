package rxjavaS.impl;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Merging {
    public static void main(String[] args) {
        simpleMarge();
        flatMapOp();
        simpleConcat();
        concatWithTake(2);
    }


    /*
        Observable.merge() will combine multiple Observable<T> sources
        emitting the same type T and consolidate into a single Observable<T>.
        It works on infinite Observables and does not necessarily guarantee
        that the emissions come in any order.
    */

    public static void simpleMarge(){
        Observable<String> source1 = Observable.just("A", "B", "C", "D");
        Observable<String> source2 = Observable.just("E", "F", "G", "H");

        Observable.merge(source1, source2).subscribe(System.out::println);

        List<Observable<String>> res = Arrays.asList(source1, source2);
        Observable.merge(res).subscribe(System.out::println);
    }


    public static void flatMapOp(){
        Observable<String> names1 = Observable.just("12345/46/47", "54321/2/3", "98765/64/76543");
        //names1.flatMap(s -> Observable.fromArray(s.split(""))).subscribe(System.out::println);

        names1.flatMap(s -> Observable.fromArray(s.split("/")))
                .filter(s -> s.matches("[0-9]+"))
                .subscribe(System.out::println);

        names1.flatMap(s -> Observable.fromArray(s.split("/")), (s,r) -> s + "-" + r)
                .subscribe(System.out::println);
    }


    /*
    * combine the emissions of multiple Observables, but will fire
    * each one sequentially and only move to the next after onComplete() is called.
    *
    * */
    public static void simpleConcat(){
        Observable<String> source1 = Observable.just("A", "B", "C", "D");
        Observable<String> source2 = Observable.just("E", "F", "G", "H");

        Observable.concat(source1, source2).subscribe(System.out::println);
    }


    // take(int) - emit finite number of Observables

    public static void concatWithTake(int takeVal){
        //emit every second, but only take 2 emissions
        Observable<String> source1 =
                Observable.interval(1, TimeUnit.SECONDS)
                        .take(takeVal)
                        .map(l -> l + 1) // emit elapsed seconds
                        .map(l -> "Source1: " + l + " seconds");
        //emit every 300 milliseconds
        Observable<String> source2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        .map(l -> (l + 1) * 300) // emit elapsed milliseconds
                        .map(l -> "Source2: " + l + " milliseconds");
        Observable.concat(source1, source2)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
        //keep application alive for 5 seconds
        sleep(5000);
    }


    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
