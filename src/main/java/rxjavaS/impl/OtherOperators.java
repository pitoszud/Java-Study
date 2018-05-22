package rxjavaS.impl;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class OtherOperators {
    public static void main(String[] args) {
        startWithOp();
    }


    public static void startWithOp(){
        Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma", "Delta")
                .startWithArray("AVAILABLE ITEMS", "---------------------")
                .subscribe(System.out::println);
    }
}
