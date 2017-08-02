/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author UPatryk
 */
public class SuperExtends {
    public static void main(String[] args) {
        //List<Number> nums = Arrays.asList(1, 2);  - this won't work as Number does not have add method
        List<Number> nums = new ArrayList<>();
        List<Integer> ints = Arrays.asList(1, 2);  // <T> List<T> asList(T... a) {return new ArrayList<>(a);}
        List<Double> dbls = Arrays.asList(2.78, 3.14);  // <T> List<T> asList(T... a) {return new ArrayList<>(a);}
        List<Object> anyNum = Arrays.<Object>asList(2.50, "four", 87, 0.585);
        nums.addAll(ints);
        nums.addAll(dbls);
        //Collections.copy(anyNum, nums); // <T> void copy(List<? super T> dest, List<? extends T> src)
        copyFromTo(anyNum, nums);
        for (Number eachNum : nums) {
            System.out.println(eachNum);
        }
    }
    
    // use a super wildcard when you only put values into a structure
    // use an extends wildcard when you only get values out of a structure
    // don't use a wildcard when you both get and put
    public static <T> void copyFromTo(List<? super T> dst, List<? extends T> src){
        for (int i = 0; i < src.size(); i++) {
        dst.set(i, src.get(i));
        }
    }
}
