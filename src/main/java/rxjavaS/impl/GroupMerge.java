package rxjavaS.impl;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GroupMerge {
    public static void main(String[] args) {
        //simpleMarge();
        //flatMapOp();
        //simpleConcat();
        //concatWithTake(2);
        //simpleZipping();
        //simpleCombineLatest();
        simpleLatestFrom();
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





    // Zipping allows to take an emission from each Observable source
    // and combine it into a single emission.

    // if one or more sources are producing emissions faster than another, zip() will queue up
    // those rapid emissions as they wait on the slower source to provide emissions.
    // This could cause undesirable performance issues as each source queues in memory.

    private static void simpleZipping(){
        Observable<String> source1 = Observable.just("One", "Two", "Three", "Four");
        Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);
        Observable.zip(source1, source2, (str, sec) -> str)
                .subscribe(str -> System.out.println(str + " received at " + LocalTime.now()));
        sleep(4000);
    }


    // combineLatest is a first come first serve solution
    // where caching and pairing the latest emission is peformed

    private static void simpleCombineLatest(){
        Observable<Long> source1 = Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);
        Observable.combineLatest(source1, source2, (l1,l2) -> "SOURCE 1: " + l1 + " SOURCE 2: " + l2)
                .subscribe(System.out::println);

        sleep(3000);
    }

    //SOURCE 1: 0 - no emissions from source 2 yet so this will not print
    //SOURCE 1: 1 - no emissions from source 2 yet so this will not print

    //SOURCE 1: 2 SOURCE 2: 0
    //SOURCE 1: 3 SOURCE 2: 0
    //SOURCE 1: 4 SOURCE 2: 0
    //SOURCE 1: 5 SOURCE 2: 0

    //SOURCE 1: 5 SOURCE 2: 1 - source 1 starts from the latest emission 5
    //SOURCE 1: 6 SOURCE 2: 1
    //SOURCE 1: 7 SOURCE 2: 1
    //SOURCE 1: 8 SOURCE 2: 1
    //SOURCE 1: 9 SOURCE 2: 1

    //SOURCE 1: 9 SOURCE 2: 2 - source 1 starts from the latest emission 9

    private static void simpleLatestFrom(){
        Observable<Long> source1 = Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);
        source2.withLatestFrom(source1, (l1,l2) -> "SOURCE 1: " + l1 + " SOURCE 2: " + l2)
                .subscribe(System.out::println);

        sleep(3000);
    }

    //SOURCE 1: 0 SOURCE 2: 2
    //SOURCE 1: 1 SOURCE 2: 5



    public static void simpleGrouping(){
        Observable<String> source = Observable.just("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        Observable<GroupedObservable<Integer, String>> byLength = source.groupBy(String::length);
    }




    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
