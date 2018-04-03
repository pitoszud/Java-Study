package rxjavaS.impl;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

import static rxjavaS.impl.ObservableMethods.sleep;

public class DisposeEx {
    public static void main(String[] args) {
        //singMaybe();
        enforceGarbageCollector();
    }

    public static void enforceGarbageCollector(){
        Observable<Long> secs = Observable.interval(1, TimeUnit.SECONDS);
        io.reactivex.disposables.Disposable disposable = secs.subscribe(l -> System.out.println(l));
        sleep(5000);
        disposable.dispose();
        sleep(5000);
    }




    public static void singMaybe(){
        // Single.just("Patryk").map(String::length)...
        Single<String> source1 = Single.just("Patryk");
        source1.map(String::length)
                .subscribe(System.out::println, Throwable::printStackTrace);

        Observable<String> source2 = Observable.just("A", "B", "C", "E", "F", "G");
        source2.first("X")
                .subscribe(System.out::println);

        Maybe<Integer> source3 = Maybe.just(18);
        source3.subscribe(System.out::println, Throwable::printStackTrace);
    }

}
