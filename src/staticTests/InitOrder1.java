/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticTests;

/**
 *
 * @author patry
 */
public class InitOrder1 {
    private String name = "Pitos"; 
    {System.out.println(name);} //3
    private static int COUNT = 0; 
    static {System.out.println(COUNT);} //2a
    static {COUNT += 10; System.out.println(COUNT);} //2b
    
    public InitOrder1(){
        System.out.println("constructor"); //4
    }
    
    public static void main(String[] args) {
        InitOrder1 io1 = new InitOrder1();
    }
}




