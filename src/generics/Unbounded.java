package generics;


import java.util.ArrayList;
import java.util.List;

public class Unbounded {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("nameA");

        //firstProblem(words); // List<String> cannot be assigned to List<Object>.
        firstProblemFixed(words);
    }

    public static void firstProblem(List<Object> list){
        for (Object x : list){
            System.out.println(x); // e.g List<String> cannot be assigned to List<Object>
        }
    }

    public static void firstProblemFixed(List<?> list){
        for (Object x : list){
            System.out.println(x); // e.g List<?> can be assigned to List<Object>
        }
    }
}
