/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author UPatryk
 */
public class ExcE {
    public static void main(String[] args) {
        run(3);
    }
    
    public static void run(int n) {
        try {
            switch (n) {
                case 1:
                    System.out.println("1st case");
                    return;
                case 3:
                    System.out.println("3rd case");
                    throw new RuntimeException("3!");
                case 4:
                    System.out.println("4th case");
                    throw new Exception("4!");
                case 5:
                    System.out.println("2nd case");
            }
        } catch (RuntimeException e) {
            System.out.print("RuntimeException: ");
            System.out.println(e.getMessage());
            throw new RuntimeException("2");
        } catch (Exception e) {
            System.out.print("Exception: ");
            System.out.println(e.getMessage());
        } 
        finally {
            System.out.println("try-block entered.");
        }
    }
}
