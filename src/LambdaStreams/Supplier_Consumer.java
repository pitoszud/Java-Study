package LambdaStreams;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
//import java.util.function.Supplier;

@FunctionalInterface
interface Supplier<T>{
    public T get();
}

@FunctionalInterface
interface Consumer<T>{
    void accept(T t);
}

@FunctionalInterface
interface BiConsumer<T, U>{
    void accept(T t, U u);
}

public class Supplier_Consumer {

    public static void main(String[] args) {

        // no input/parameters but an output is returned.
        Supplier<LocalDate> supplier1 = LocalDate::now;
        Supplier<LocalDate> supplier2 = () -> LocalDate.now();

        Supplier<StringBuilder> supplier3 = () -> new StringBuilder();

        System.out.println(supplier1.get());
        System.out.println(supplier2.get());
        System.out.println(supplier3.get().append("String"));


        // there is an input, and
        // some operation is to be performed on the object without returning any result.
        Consumer<Integer> consumer1 = it -> System.out.println(it * 2);
        consumer1.accept(5);

        Map<Integer, String> kmap = new HashMap<>();
        BiConsumer<Integer, String> consumer2A = kmap::put;
        BiConsumer<Integer, String> consumer2B = (k, v) -> kmap.put(k, v);

        consumer2A.accept(1, "One");
        consumer2B.accept(2, "Two");
        System.out.println(kmap);

    }
}
