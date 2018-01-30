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
public class InnerVSNested {
    public static class Nested{
        private final double valA = 0.7;
    }
    
    public class Inner{
        private final double valB = 0.8;
    }
    
    public static void main(String[] args) {
        // no need to initialise enclosing class with static nested class
        Nested nested = new Nested();
        System.out.println(nested.valA);
        
        InnerVSNested enclosing = new InnerVSNested();
        Inner inner = enclosing.new Inner();
        System.out.println(inner.valB);
        
    }
}
