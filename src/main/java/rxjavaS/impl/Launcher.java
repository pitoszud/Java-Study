package rxjavaS.impl;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Launcher {
    public static void main(String[] args) {
        //justObs();
        //createObs();
        //onNextMethod();
        fromCallableMethod();
    }

    public static void justObs(){
        // just
        Observable<String> source1 = Observable.just("Task One", "Task Two", "Task Three", "Task Four", "Task Five");
        source1.map(String::length).subscribe(System.out::println);


        // fromIterable (Observable subscribes single ObservableMethods)
        List<Integer> ageList = Arrays.asList(1982, 1983, 1997, 1993, 2000, 1970, 1963, 1948, 1955, 1958);
        Observable<Integer> source2 = Observable.fromIterable(ageList)
                .map(a -> 2018 - a)
                .filter(a -> a >= 18);
        source2.subscribe(System.out::println);


        // ConnectableObservable (Observable subscribes many Observers)
        ConnectableObservable<String> source3 = Observable.just("Anna", "Andrzej", "Kamil", "Eryk", "Iwona", "Oliwia", "Natalia", "Paulina", "Patryk")
                .publish();

        source3.subscribe(System.out::println);
        source3.subscribe(s -> System.out.println("last char : " + s.charAt(s.length()-1)));
        source3.map(String::length).subscribe(l -> System.out.println("at index " + (l-1)));
        source3.connect();




        // compare RxJava Observable with Java streams
        List<String> strL = Arrays.asList("Task One", "Task Two", "Task Three", "Task Four", "Task Five");
        List<Integer> intL = strL
                .stream()
                .map(s -> s.length() - 5)
                .collect(Collectors.toList());
    }

    // Observable.create
    public static void createObs(){
        Observable<String> source1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    emitter.onNext("Task One");
                    emitter.onNext("Task Two");
                    //...
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
        source1.map(s -> s.length() + 5).subscribe(System.out::println);

        Observable<String> source2 = Observable.create(emitter -> {
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
        source2.map(s -> s.length() - 5).subscribe(System.out::println);

    }


    public static void onNextMethod(){
        Observable<Integer> source3 = Observable.just(35, 23, 19, 53, 20, 17, 63, 48, 55, 38);

        Observer<Integer> source4 = new Observer<Integer>(){
            //private Disposable d;

            @Override
            public void onSubscribe(Disposable d) {
                //this.d = d;
            }

            @Override
            public void onNext(Integer val) {
                System.out.println("received: " + val);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }

        };

        source3.map(b -> 2018 - b)
                .filter(y -> y < 1998)
                .subscribe(source4);

        // passing arguments to onNext, onError, onComplete
        source3.map(b -> 2018 - b)
                .filter(y -> y < 1998)
                .subscribe(
                        val -> System.out.println("recived " + val),
                        Throwable::printStackTrace,
                        () -> System.out.println("done"));

    }


    public static void fromCallableMethod(){
        String str = null;
        Observable.fromCallable(() -> str.equals("A"))
                .subscribe(i -> System.out.println("received: " + i), e -> System.err.println("Err: " + e));
    }




    //Observable<String> str = Observable.just("Task One", "Task Two", "Task Three", "Task Four", "Task Five");
    // return fromArray(item1, item2, item3, item4, item5); ==> public static <T> Observable<T> fromArray(T... items)
    // return RxJavaPlugins.onAssembly(new ObservableFromArray<T>(items)); ==> public static <T> Observable<T> onAssembly(@NonNull Observable<T> source)
    // return apply(f, source); ==> static <T, R> R apply(@NonNull Function<T, R> f, @NonNull T t)
    // return f.apply(t); ==> R apply(@NonNull T t) throws Exception;

    //str.map(s -> s.length()).subscribe(i -> System.out.println(i));
    // return subscribe(onNext, Functions...) ==> public final DisposeEx subscribe(Consumer<? super T> onNext)
    // subscribe(ls); ==> public final void subscribe(ObservableMethods<? super T> observer)
    // return ls ==> new LambdaObserver<T>(onNext, onError, onComplete, onSubscribe);
}
