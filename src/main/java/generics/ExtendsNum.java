/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// use a super wildcard when you only put values into a structure
// use an extends wildcard when you only get values out of a structure
// don't use a wildcard when you both get and put
public class ExtendsNum {
    public static void main(String[] args) {
        List<Double> doubles = Arrays.asList(2.58, 5.97, 2.44);
        Double dblV = sumNumbers(doubles);
        
        List<Number> nums = Arrays.asList(1,2,3,4);
        addToList(nums,5.0);
    }
    
    // super => put
    // extend => get
    // none => get && put
    public static double sumNumbers(Collection<? extends Number> nums){
        double d = 0.0;
        for (Number num : nums) {
            d += num.doubleValue();
        }
        System.out.println("total: " + d);
        return d;
    }
    
    public static <T> void addToList(List<? super T> num, T numAdd){
        num.set(num.size()-1, numAdd);
        System.out.println(num);
    }
}
