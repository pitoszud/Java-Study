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
public class InitOrder2 {
    private String name = "Pitos"; 
    {System.out.println(name);} //3a
    private static int COUNT = 0; 
    static {System.out.println(COUNT);} //2
    {COUNT += 10; System.out.println(COUNT);} //3b
    
    public InitOrder2(){
        System.out.println("constructor"); //4
    }
    
    public static void main(String[] args) {
        InitOrder2 io2 = new InitOrder2();
    }
}