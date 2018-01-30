package generics;


import java.util.ArrayList;
import java.util.List;

public class UpperBound {
    public static void main(String[] args) {
        List<Long> l = new ArrayList<>();
        l.add(12489843L);

        //long lNum1 = firstProblem(l); // DOES NOT COMPILE: Number cannot be applied to Long
        long lNum2 = firstProblemFixed(l);

       //List<Number> lex = new ArrayList<Long>(); // DOES NOT COMPILE
        List<? extends Number> lexf = new ArrayList<Long>();
    }

    public static long firstProblem(List<Number> list){
        long count = 0;
        for (Number x : list){
            count += x.intValue();
        }
        return count;
    }

    public static long firstProblemFixed(List<? extends Number> list){
        long count = 0;
        for (Number x : list){
            count += x.intValue();
        }
        return count;
    }
}
