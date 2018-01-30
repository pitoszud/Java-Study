package generics;


import java.util.ArrayList;
import java.util.List;

public class LowerBound {
    public static void main(String[] args) {
        List<Integer> numL = new ArrayList<>();
        numL.add(1);
        numL.add(2);
        numL.add(3);

        List<Object> objects = new ArrayList<>(numL);

        addNum(numL);
        addNum(objects);
    }

    public static void addNum1(List<?> list){
        //list.add(4); // DOES NOT COMPILE: unbounded generics are immutable
    }

    public static void addNum2(List<? extends Object> list){
        //list.add(4); // DOES NOT COMPILE: upper-bounded generics are immutable

        long count = 0;
        for (Object o : list){
            Number n = (Number) o;
            count += n.intValue();
        }
    }


    public static void addNum5(List<? extends Number> list){
        //list.add(4); // DOES NOT COMPILE: upper-bounded generics are immutable
    }

    public static void addNum3(List<Object> list){
        //list.add(4); // Compiles, but Object cannot be applied to List<String>
    }


    public static void addNum4(List<? super Integer> list){
        list.add(4); // the list is superclass of Integer

        long count = 0;
        for (Object o : list){
            Number n = (Number) o;
            count += n.intValue();
        }
    }
}
