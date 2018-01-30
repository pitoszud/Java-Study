/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LambdaStreams.LambdaStreamsA;

/**
 *
 * @author UPatryk
 */
public class DefaultMethod {
    public static void main(String[] args) {
        
        
        Mum m1 = new LittleBrother();
        m1.prepareFood();
        // Daughter is making a dinner
        
        Mum m2 = new BiggerBrother();
        m2.prepareFood();
        // iggerBrother is making a dinner
        
    }
    
    interface Mum{
        public void shopping(String name);
        
        public default void prepareFood(){
            System.out.println("Parent is making a dinner");
        }
        
        public String getShopping();
    }
    
    interface Daughter extends Mum{
        // an optional override
        @Override
        public default void prepareFood(){
            System.out.println("Daughter is making a dinner");
        }
        
        // prepareFood() is inherited from Mum
    }
    
    public static class Dad implements Mum{
        private String name;
        
        // required override
        @Override
        public void shopping(String name) {
            this.name = name;
        }
        
        // required override
        @Override
        public String getShopping() {
            return name;
        }
    }
    
    public static class LittleBrother extends Dad implements Daughter, Mum{
        // shopping(), getShopping() inherited from Dad
        // prepareFood() inherited from Daughter
    }
    
    public static class BiggerBrother extends Dad implements Daughter, Mum{
        @Override
        public void prepareFood(){
            System.out.println("BiggerBrother is making a dinner");
        }
    }
        
}


