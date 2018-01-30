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
public class InitOrder3 {
    static { add(2); } //2a
    static void add(int num) { System.out.print(num + " "); }
    InitOrder3() { add(5); } //4a
    static { add(4); } //2b
    { add(6); } //3a
    static { new InitOrder3(); }
    { add(8); } //3b
    public static void main(String[] args) { } 
}