package rxjavaS.impl;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.net.URL;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class ObserveOnExample{
    public static void main(String[] args) throws InterruptedException {
        //observerOnEx();

        //observerOnWithFlatMapA();
        //observerOnWithFlatMapB();
        observerOnWithFlatMapC();

        //observeOnWithFromCallable();
    }

    /*
    * subscribeOn() specifies a Scheduler (thread pool)
    * where the work is performed after subscription is made in subscribe()
    *
    *
    * The results of transformation are received on the same thread as the thread that did the actual work.
    * This can be changed using observeOn()
    * */

    public static void observerOnEx() throws InterruptedException {

        Observable.just("one", "two", "three", "four")
                .doOnNext(c -> System.out.println("Item: " + c + " on Thread: " + Thread.currentThread().getName()))
                .subscribeOn(Schedulers.newThread())
                .map(String::length)
                .observeOn(Schedulers.computation())
                .reduce((total, next) -> total + next)
                .subscribe(l -> System.out.println("length: " + l + " on Thread " + Thread.currentThread().getName()));

        //.blockingSubscribe(integer -> System.out.println("Thread: " + Thread.currentThread().getName()))


        // the main thread has to live longer than the background thread
        Thread.sleep(20000);


    }

    // Sequential implementation
    public static void observerOnWithFlatMapA() throws InterruptedException {
        Observable.just("ready", "steady", "go")
                .flatMap(v -> performLongOperation(v)
                        .doOnNext(s -> System.out.println("Item: " + s + " on Thread: " + Thread.currentThread().getName()))
                        .subscribeOn(Schedulers.newThread()))
                .subscribe(l -> System.out.println("length: " + l + " on Thread " + Thread.currentThread().getName()));

        Thread.sleep(4000);
    }

    // Parallel implementation on each emission - Big overhead, so it works well with smaller number of emissions
    public static void observerOnWithFlatMapB() throws InterruptedException {
        Observable.range(1,10)
                .flatMap(i -> Observable.just(i)
                        .subscribeOn(Schedulers.computation())
                        .map(i2 -> intenseCalculation(i2)))
                .subscribe(i -> System.out.println(
                        "Received " + i + " " + LocalTime.now() + " on thread " + Thread.currentThread().getName()));

        sleep(20000);
    }


    // Splitting the Observable into n-Observables where n is a number of CPU cores.
    public static void observerOnWithFlatMapC(){
        int coreCount = Runtime.getRuntime().availableProcessors();
        AtomicInteger assigner = new AtomicInteger(0);
        Observable.range(1,10)
                .groupBy(i -> assigner.incrementAndGet() % coreCount)
                .flatMap(grp -> grp.observeOn(Schedulers.io())
                        .map(i2 -> intenseCalculation(i2)))
                .subscribe(i -> System.out.println("Received " + i + " " + LocalTime.now() + " on thread " + Thread.currentThread().getName()));

        sleep(20000);
    }



    public static void observeOnWithFromCallable(){
        Observable.fromCallable(() ->
                getResponse("https://api.github.com/users/thomasnield/starred"))
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println);

        sleep(10000);
    }



    private static String getResponse(String path) {
        try {
            return new Scanner(
                    new URL(path).openStream(),"UTF-8").useDelimiter("\\A").next();
        } catch (Exception e) {
            return e.getMessage();
        }
    }



    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    protected static Observable<Integer> performLongOperation(String v) {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(3) * 1000);
            return Observable.just(v.length());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }
}
