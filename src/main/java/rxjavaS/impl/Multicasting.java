package rxjavaS.impl;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.ThreadLocalRandom;

public class Multicasting {


    public static void main(String[] args) {
        //simpleMulticast();
        //multicastWithInterOp();
        multicastWithFork();
    }


    public static void simpleMulticast(){
        // onClick (Observable) - multiple fragments (Observers) will receive stream at the same time (concurrently)
        ConnectableObservable<String> source3 = Observable.just("Anna", "Andrzej", "Kamil", "Eryk", "Iwona", "Oliwia", "Natalia", "Paulina", "Patryk")
                .publish();

        source3.subscribe(s -> System.out.println("Observer1 -" + s));
        source3.subscribe(s -> System.out.println("Observer2 - last char : " + s.charAt(s.length()-1)));
        source3.map(String::length).subscribe(l -> System.out.println("Observer3 - at index " + (l-1)));
        source3.connect();
    }


    public static void multicastWithInterOp(){
        ConnectableObservable<Integer> randomNums = Observable.range(1,5)
                .map(i -> randomInt())
                .filter(i -> i > 17)
                .publish();

        randomNums.subscribe(i -> System.out.println("Observer 1: " + i));
        randomNums.subscribe(i -> System.out.println("Observer 2: " + i));
        randomNums.connect();
    }

    public static void multicastWithFork(){
        ConnectableObservable<Integer> randomNums = Observable.range(1,5)
                .map(i -> randomInt())
                .filter(i -> i > 17)
                .publish();

        randomNums.subscribe(i -> System.out.println("Observer 1: " + i));
        randomNums.reduce(0, (total, next) -> total + next).subscribe(i -> System.out.println("Observer 2: " + i));
        randomNums.connect();
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100);
    }
}
