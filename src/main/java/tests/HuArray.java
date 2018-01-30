/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author UPatryk
 */
public class HuArray {
    public static void main(String[] args) {
        //toArrayExample();
        arrayToListExample();
    }
    
    public static void toArrayExample(){
        List<String> listStr = Arrays.asList("One", "Two", "Three");
        String[] arrStr1 = (String[]) listStr.toArray();
        Object[] arrStr2 = listStr.toArray();
        String[] arrStr3 = listStr.toArray(new String[0]);
        String[] arrStr4 = listStr.toArray(new String[listStr.size()]);
        String[] arrStr5 = listStr.toArray(new String[7]);
        
        System.out.println("\n" + Arrays.toString(arrStr1) + "\n" + 
                Arrays.toString(arrStr2) + "\n" + 
                Arrays.toString(arrStr3) + "\n" + 
                Arrays.toString(arrStr4) + "\n" + 
                Arrays.toString(arrStr5));
    }
    
    public static void arrayToListExample(){
        String[] array = { "zero", "three", "four" }; // [hawk, robin]
        List<String> list1 = Arrays.asList(array); // returns fixed size list
        
        List<String> list2 = new ArrayList<>(); // returns variable size list
        list2.add("zero");
        list2.add("three");
        list2.add("four");
        
        list1.set(1, "one"); // [zero, three, four] -> [zero, one, four] - updates both array and list
        //list1.add(2, "three"); // UnsupportedOperation - you cannot modify the size
        list1.set(2, "two"); // [zero, one, four] -> [zero, one, two]
        array[2] = "three"; // [zero, one, two] -> [zero, one, three] - updates both array and list
        //list1.remove(2); // UnsupportedOperation - you cannot modify the size
        list1.set(2, "two");
        
        
        
        list2.set(1, "two"); // [zero, three, four] -> [zero, two, four]
        list2.add(1, "one"); // [zero, two, four] -> [zero, one, two, four]
        list2.remove(list2.size()-1); // [zero, one, two, four] -> [zero, one, two]
        
        
        System.out.println("array1:" + Arrays.toString(array)); // array1:[zero, one, two]
        System.out.println("list1: " + list1); // list1: [zero, one, two]
        System.out.println("list2: " +list2); // list2: [zero, one, two]
    }
}
