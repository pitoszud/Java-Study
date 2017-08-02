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
public class IntAssigment {
    public static void main(String[] args) { 
        int number = 1; 
        
        getNumberB(number); 
        System.out.println(number); // 1 
         
        
        number = getNumberA(number);
        System.out.println(number); // 1 
         
        
        number = getNumberB(number);
        System.out.println(number);  // 2 
    } 
     
     
    public static int getNumberA(int number){ 
        System.out.println("getNumberA method returns " + number); 
        return number++; // increase and return initial value 
    } 
     
    public static int getNumberB(int number){ 
        ++number; // increase and return new value 
        // number += 1;  
        System.out.println("getNumberB method returns " + number); 
        return number; 
    } 
}
