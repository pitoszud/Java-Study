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
public class InterfaceEx1 {
    public interface Herbivore {
        //private int NUMA = 1; // DOES NOT COMPILE - interface can only have public an static variables
        public static final int NUMB = 2;
        int NUMC = 3; // public static final added automatically by the complier
        
        public abstract int eatPlants();
        int eatPlants2();  // public abstract added automatically by the complier
        
        //public static void printListA(); // DOES NOT COMPILE - static methods must have body
        public static void printListB(){ // accessed by class referencing InterfaceEx1.printList();
            System.out.println("printing a list...");
        }
        
        //public default void printListC(); // DOES NOT COMPILE - default methods must have body
        public default void printListD(){
            System.out.println("printing a list...");
        }
    }
    
    public interface Omnivore {
        public void eatPlants(); // abstract is added automatically by complier
        public void eatMeat(); // abstract is added automatically by complier
    }
    
     /*

    public class Bear implements Herbivore, Omnivore {


        public int eatPlants() { // DOES NOT COMPILE - return types must be consistent
            System.out.println("Eating plants: 10");
            return 10;
        }




        public void eatPlants() { // DOES NOT COMPILE - return types must be consistent
            System.out.println("Eating plants");
        }


        @Override
        public void eatMeat() {
            System.out.println("eating meat");
        }
    }
    
    // DOES NOT COMPILE - incompatible interfaces
    public interface Supervore extends Herbivore, Omnivore {}
    
    
    // DOES NOT COMPILE - incompatible interfaces
    public abstract class AbstractBear implements Herbivore, Omnivore {}

    */
}
