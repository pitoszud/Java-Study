/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author UPatryk
 */
public class InterfaceEx4 {
    public interface DarkForest {
        public default void getName(){ // default if not overriden
            System.out.println("Dark Forest ");
        }
    }
    
    public interface GreenForest {
        public default void getName(){ // default if not overriden
            System.out.println("GreenForest");
        }
    }
    
    
    public static class Dear implements GreenForest {
        // does not have to override default method - will inherit from Omnivoer
    }
    
    
    public class Bear implements DarkForest, GreenForest {
        // Has to be overriden since the class implements the same method from two interfaces
        @Override
        public void getName(){
            System.out.println("Bear");
        }
    }
    
    public class Bear2 implements DarkForest, GreenForest{
        @Override
        public void getName(){
            GreenForest.super.getName();
        }
    }
    
    
    public interface Wolf extends DarkForest{
        // DOES NOT COMPILE - must be default or abstract
//        @Override
//        public void getName(){
//            System.out.println("Wolf");
//        }
    }
    
    
    public interface Tur extends DarkForest{
        @Override
        public abstract void getName(); // replaces default method with abstract method
    }
    
    
    
    public class Doe implements Tur  {
        
        @Override
        public void getName() {
            System.out.println("Doe");
        }
        
    }
}