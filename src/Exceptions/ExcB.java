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
public class ExcB {
    public String name;
    
    public void run(){
        System.out.println("1"); // 1
        try {
            System.out.println("2"); // 2
            name.toString(); // throws NullPointerException - go to catch
            System.out.println("3"); // unreachable statement
        } catch (NullPointerException npe) { // catch NullPointerException
            System.out.println("4"); // 4
            throw npe; // throw NullPointerException
        }
        System.out.println("5"); // unreachable statement
    }
    
    public static void runWithoutTryCatch() {
        ExcB e0 = new ExcB();
        e0.run(); // does not catch NullPointerException, exit(0)
        System.out.println("6"); // unreachable statement
    }
    
    
    public static void runWithTryCatch() {
        ExcB e1 = new ExcB();
        try {
            e1.run(); // throws NullPointerException - go to catch
        } catch (Exception exc) {
            System.out.println("6"); // 6
        }
        System.out.println("7"); // 7
    }
    
    
    
    public static void main(String[] args) {
        runWithoutTryCatch();
        //runWithTryCatch();
    }
}
