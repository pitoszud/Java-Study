package rxjavaS.impl;
import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ObservableMethods {
    private static int start = 5;
    private static int count = 10;

    public static void main(String[] args) {
        //rangeCount();
        //intervalCount();
    }

    public static void rangeCount(){
        List<Integer> numsA = new ArrayList<>();
        Observable.range(5,10).subscribe(n -> numsA.add(n));
        Collections.sort(numsA);
        System.out.println(numsA);

        List<Integer> numsB = new ArrayList<>();
        Observable<Integer> source = Observable.range(5,10);
        source.subscribe(n -> numsB.add(n));
        Collections.sort(numsB);
        System.out.println(numsB);
    }

    // use defer() if you want to make sure that
    // the state changes are captured by each subsequent observer
    public static void rangeCountStatic(){
        Observable<Integer> source = Observable
                .defer(() -> Observable.range(start,count));
        source.subscribe(i -> System.out.println("Observer 1: " + i));
        //modify count
        count = 10;
        source.subscribe(i -> System.out.println("Observer 2: " + i));
    }

    public static void intervalCount() {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println(s + " ra ta ta ta ta ta ta..."));
        sleep(5000);
    }






    public static void emptyAndNever(){
        Observable<String> empty = Observable.empty();
        empty.subscribe(System.out::println,
                Throwable::printStackTrace,
                ()-> System.out.println("done"));

        // emitter does not call onComplete() in never() method
        Observable<String> never = Observable.never();
        never.subscribe(System.out::println,
                Throwable::printStackTrace,
                ()-> System.out.println("done"));

    }







    // helper method for intervalCount()
    public static void sleep(int millis){
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


}
