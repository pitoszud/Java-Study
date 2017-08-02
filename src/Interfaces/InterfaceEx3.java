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
public class InterfaceEx3 {
    public interface Herbivore {
        public void eatPlants(int a);
        public default double getTemparature(){ // default if not overriden
            return 10.0;
        }
    }
    
    public interface Omnivore {
        public void eatPlants(String s);
        public void eatMeat();
    }
    
    public class Bear implements Herbivore, Omnivore {
        
        @Override
        public void eatPlants(int a) {
            System.out.println("Eating plants: 10 " + a);
        }
        
        @Override
        public void eatPlants(String s) {
            System.out.println("eating plant");
        }
        
        // overloading - different signature
        public void eatPlants(){ 
            System.out.println("overloaded plant");
        }
        

        @Override
        public void eatMeat() {
            System.out.println("eating meat");
        }

        // overloading - different type + signature
        public String eatMeat(int a){
           return "overloading meat " + a; 
        }
        
        @Override
        public double getTemparature(){
            return 20.0;
        }
    }
}