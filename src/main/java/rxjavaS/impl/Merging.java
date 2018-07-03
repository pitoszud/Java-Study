package rxjavaS.impl;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class Merging {
    public static void main(String[] args) {
        flatMapOp();
    }


    public static void simpleMarge(){
        Observable<String> source1 = Observable.just("A", "B", "C", "D");
        Observable<String> source2 = Observable.just("E", "F", "G", "H");

        /*
        Observable.merge() will combine multiple Observable<T> sources
        emitting the same type T and consolidate into a single Observable<T>.
        It works on infinite Observables and does not necessarily guarantee
        that the emissions come in any order.
        */

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
}
