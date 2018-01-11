package LambdaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
public class PredicateEx2{

    public static List<Integer> filterList(List<Integer> listOfIntegers, Predicate<Integer> predicate){
        List<Integer> filteredList = new ArrayList<Integer>();
        for(Integer integer:listOfIntegers){
            if(predicate.test(integer)){
                filteredList.add(integer);
            }
        }
        return filteredList;
    }

    public static void main(String args[]){

        List<Integer> integerList = Arrays.asList(
                new Integer(1),new Integer(10),
                new Integer(200),new Integer(101),
                new Integer(-10),new Integer(0));

        Predicate<Integer> positive = i -> i > 0;
        List<Integer> filteredList = filterList(integerList, positive);

        List<Integer> filteredList2 = filterList(integerList, i -> i > 0);

        filteredList.forEach(System.out::println);
        filteredList2.forEach(System.out::println);
    }




}