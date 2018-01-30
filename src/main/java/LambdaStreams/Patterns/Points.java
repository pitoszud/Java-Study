package LambdaStreams.Patterns;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class Points {
    private static List<Point> pointList = new ArrayList<>();
    public interface Consumer<T> extends java.util.function.Consumer<T>{
        void accept(T t);
    }

    public static void getMaxDist(){
        List<Integer> intList = Arrays.asList(23,58,6,78,28,97,11,74,63,37,85,24,12);

        OptionalDouble maxDist = intList.parallelStream()
                .map(i -> new Point(i%3,i/3))
                .mapToDouble(p -> p.distance(0,0))
                .max();
        System.out.println(maxDist);
    }

    public static void main(String[] args) {

        getMaxDist();
    }

}