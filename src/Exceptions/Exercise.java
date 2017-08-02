/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author upatryk
 */
public class Exercise {
    public void swim(){
        System.out.println("swim 25m freestyle"); // print 1
        try {
            turn();
        } catch (ArithmeticException ae) { // NullPointerException is not caught here - go to finally
            System.out.println("swim 25m breaststroke");
        } finally{
            System.out.println("rest 10 sec"); // print 3
        }
        System.out.println("swim 25m kick"); // unreachable statement
    }
    
    public void turn(){
        System.out.println("tumble turn"); // print 2
        Object o = null;
        o.toString(); // java.lang.NullPointerException - go to catch
        System.out.println("push from the wall");
    }
    
    public static void main(String[] args) {
        new Exercise().swim();
    }
    
}
