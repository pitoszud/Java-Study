/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LambdaStreamsA;

import java.util.*;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import java.util.stream.Collectors.*;
import static javafx.scene.input.KeyCode.*;

/**
 *
 * @author UPatryk
 * @param <T> any type
 */
public class CustomCollector<T> implements Collector<T, List<T>, List<T>> {
    

    @Override
    public Supplier<List<T>> supplier() {
        return () -> new ArrayList<>();
        //return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return (list, item) -> list.add(item);
        //return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return (List<T> l1, List<T> l2) -> {
            l1.addAll(l2);
            return l1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        //return Function.identity();
        return i -> i;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
    }
    
    
}
