package rxjavaS.impl;
import io.reactivex.*;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

import static rxjavaS.impl.ObservableMethods.sleep;

public class DisposeEx {
    public static void main(String[] args) {
        //singMaybe();
        //enforceGarbageCollector();
        resourceObserverEX();
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


    public static void resourceObserverEX(){
        Observable<Long> source4 = Observable.interval(1, TimeUnit.SECONDS);

        ResourceObserver<Long> observer4 = new ResourceObserver<Long>() {
            @Override
            public void onNext(Long value) {
                System.out.println(value);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("done");
            }
        };

        Disposable d = source4.subscribeWith(observer4);


        CompositeDisposable compDisp = new CompositeDisposable();

        Disposable d1 = source4.subscribe(e -> System.out.println("Observer 1" + e));
        Disposable d2 = source4.subscribe(e -> System.out.println("Observer 2" + e));
        Disposable d3 = source4.subscribe(e -> System.out.println("Observer 3" + e));

        compDisp.addAll(d1, d2, d3);

        sleep(5000);

        compDisp.dispose();

        sleep(5000);

    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void disposeSubscribe(){
        Observable<Integer> source5 = Observable.create(emitter -> {
           try{
               for (int i = 0; i < 1000; i++) {
                   while (!emitter.isDisposed()){
                       emitter.onNext(i);
                   }
                   emitter.onComplete();
               }
           } catch(Throwable e){
               emitter.onError(e);
           }
        });
    }


}
