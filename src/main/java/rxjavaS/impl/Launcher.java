package rxjavaS.impl;

import LambdaStreams.Streams.Collector;
import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Launcher {
    public static void main(String[] args) {
        justObs();
        //createObs();
    }

    public static void justObs(){
        Observable<String> source1 = Observable.just("Task One", "Task Two", "Task Three", "Task Four", "Task Five");
        source1.map(String::length).subscribe(System.out::println);


        List<Integer> ageList = Arrays.asList(1982, 1983, 1997, 1993, 2000, 1970, 1963, 1948, 1955, 1958);
        Observable<Integer> source2 = Observable.fromIterable(ageList)
                .filter(a -> a >= 18)
                .map(a -> 2018 - a);
        source2.subscribe(System.out::println);


        // comapre with Java stream
        List<String> strL = Arrays.asList("Task One", "Task Two", "Task Three", "Task Four", "Task Five");
        List<Integer> intL = strL
                .stream()
                .map(s -> s.length() - 5)
                .collect(Collectors.toList());
    }

    public static void createObs(){
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("Task One");
                emitter.onNext("Task Two");
                emitter.onNext("Task Three");
                emitter.onNext("Task Four");
                emitter.onNext("Task Five");
                emitter.onComplete();
            } catch (Throwable e) {
                emitter.onError(e);
            }
        });
        source.map(s -> s.length() - 5).subscribe(i -> System.out.println(i));

    }




    //Observable<String> str = Observable.just("Task One", "Task Two", "Task Three", "Task Four", "Task Five");
    // return fromArray(item1, item2, item3, item4, item5); ==> public static <T> Observable<T> fromArray(T... items)
    // return RxJavaPlugins.onAssembly(new ObservableFromArray<T>(items)); ==> public static <T> Observable<T> onAssembly(@NonNull Observable<T> source)
    // return apply(f, source); ==> static <T, R> R apply(@NonNull Function<T, R> f, @NonNull T t)
    // return f.apply(t); ==> R apply(@NonNull T t) throws Exception;

    //str.map(s -> s.length()).subscribe(i -> System.out.println(i));
    // return subscribe(onNext, Functions...) ==> public final Disposable subscribe(Consumer<? super T> onNext)
    // subscribe(ls); ==> public final void subscribe(Observer<? super T> observer)
    // return ls ==> new LambdaObserver<T>(onNext, onError, onComplete, onSubscribe);
}
