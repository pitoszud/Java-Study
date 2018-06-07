package rxjavaS.impl;


import io.reactivex.Observable;

public class OtherOperators {
    public static void main(String[] args) {
        startWithOp();
        switchIfEmptyOp();
        scanOp();
    }


    public static void startWithOp(){
        Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma", "Delta")
                .startWithArray("AVAILABLE ITEMS", "---------------------")
                .sorted()
                .repeat(2)
                .subscribe(System.out::println);
    }

    public static void switchIfEmptyOp(){
        Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma", "Delta")
                .filter(s -> s.startsWith("Z"))
                .switchIfEmpty(Observable.just("Zeta", "Gamma", "Delta"))
                .subscribe(System.out::println);
    }

    public static void scanOp(){
        System.out.println("scanOp example");
        Observable.just(2,4,6,8,10,12,14,16,18)
                .scan((a,n) -> a + n)
                .subscribe(System.out::println);

        Observable.just(1,3,5,7,9,11,13,15,17)
                .scan(0,(a,n) -> a + n)
                .skip(1)
                .subscribe(System.out::println);
    }




}
