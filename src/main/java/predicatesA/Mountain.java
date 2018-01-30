/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predicatesA;

/**
 *
 * @author UPatryk
 */
public class Mountain {
    public static void main(String[] args) {
        String s1 = check(4500, (i,j) -> i > j);
        String s2=  check2(4500, Mountain::isBelow);
        System.out.println(s1 + "\n" + s2);
    }

    private static String check(Integer h, ClimbPredicate cp){
        return cp.isTooHigh(h, 6000) ? "too high" : "below max high";
    }

    private static String check2(Integer h, ClimbPredicate2 cp){
        return cp.isTooHigh(h) ? "too high" : "below max high";
    }
    
    public static boolean isBelow(Integer h){
        return h > 6000;
    }
}

interface ClimbPredicate{
    boolean isTooHigh(Integer h, Integer l);
}

interface ClimbPredicate2{
    boolean isTooHigh(Integer h);
}



