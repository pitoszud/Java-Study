/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InnerClasses;

/**
 *
 * @author upatryk
 */
public class OuterA {
    private int length = 5;
    public void calculate(){
        int width = 20; // effectively final

        class InnerA{
            public void multiply(){
                System.out.println(length * width);
            }
        }

        InnerA inner = new InnerA();
        inner.multiply();
    }
    
    public static void main(String[] args) {
        OuterA outer = new OuterA();
        outer.calculate();
        
        
    }
}
