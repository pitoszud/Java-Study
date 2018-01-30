/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 *
 * @author UPatryk
 */
public class IntPlusPlus {
    public void run(){
       int i = 5;
       int iPlusPlus = i++; // increment but returns ORIGINAL value
       System.out.println("i has been incremented to " + i); // 6
       System.out.println("i++ incremented and returned ORIGINAL value " + iPlusPlus); // 5
       
       i = 5;
       int plusPlusI = ++i; // increment and returns NEW value
       System.out.println("\ni has been incremented to " + i); // 6
       System.out.println("i++ incremented and returned NEW value " + plusPlusI); // 6
       
       
    }
    
    public static void main(String[] args) {
        IntPlusPlus a = new IntPlusPlus();
        a.run();
    }
}
