package rxjavaS.impl;

import LambdaStreams.Streams.Collector;
import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Launcher {
    public static void main(String[] args) {
        Observable<String> str = Observable.just("One", "Two", "Three", "Four");
        str.map(s -> s.length()).subscribe(i -> System.out.println(i));


        List<String> strL = Arrays.asList("One", "Two", "Three", "Four");
        List<Integer> intL = strL
                .stream()
                .map(s -> s.length())
                .collect(Collectors.toList());




    }
}
