package rxjavaS.impl;

import io.reactivex.Observable;

public class ColdHot {
    public static void main(String[] args) {
        hot();
    }

    public static void hot(){
        Observable<String> source = Observable.just("Alpha","Beta","Gamma","Delta","Epsilon");

        // observer 1
        source.map(s -> s.length()).subscribe(s -> System.out.println(s));

        // observer 2
        source.map(s -> s.charAt(0)).subscribe(ch -> System.out.println(ch));
    }


}
