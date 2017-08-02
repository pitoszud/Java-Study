/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UPatryk
 */
public class Vararg {
    public static void main(String[] args) {
        List<Integer> ints = Vararg.toList(new Integer[] { 1, 2, 3 });
        List<String> words = Vararg.toList(new String[] { "hello", "world" });
        System.out.println(ints);
        System.out.println(words);
        System.out.println("---------------");
        
        List<Integer> integ = Vararg.toList2(4, 5, 6);
        List<String> word = Vararg.toList2("how", "are", "you");
        System.out.println(integ);
        System.out.println(word);
        System.out.println("---------------");
        
        List<Integer> integs = new ArrayList<>();
        Vararg.addAll(integs, 1, 2, 3);
        Vararg.addAll(integs, new Integer[] { 4, 5, 6 });
        System.out.println(integs);
        System.out.println("---------------");
    }
    
    public static <T> List<T> toList(T[] arr){
        List<T> list = new ArrayList<>();
        for(T el : arr){
            list.add(el);
        }
        return list;
    }
    
    public static <T> List<T> toList2(T... arr){
        List<T> list = new ArrayList<>();
        for(T el : arr){
            list.add(el);
        }
        return list;
    }
    
    public static <T> void addAll(List<T> list, T... arr){
        for(T elt : arr){
            list.add(elt);
        }
    }
}
