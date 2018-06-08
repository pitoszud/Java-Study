package rxjavaS.impl;

import io.reactivex.Observable;

public class Errors {
    public static void main(String[] args) {
        cErr();
    }

    public static void cErr(){
        Observable.just(5,2,4,9,0,3,2,7,8)
                .map(i -> (i*5)/i)
                .subscribe(System.out::println,
                        e -> System.out.println("error: " + e));

        Observable.just(5,2,4,9,0,3,2,7,8)
                .map(i -> (i*5)/i)
                .onErrorReturnItem(-1)
                .subscribe(System.out::println);
    }
}
