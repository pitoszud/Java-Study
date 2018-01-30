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
public class InterfaceEx2 {
    public interface Herbivore {
        public static final int VALUE_YES = 1; //
        int VALUE_NO = 0; // public static final automatically inserted by complier
        private int MAXIMUM_DEPTH = 100; // DOES NOT COMPILE - type must be public
        protected boolean UNDERWATER = false; // DOES NOT COMPILE - type must be public
        public abstract String NAME = "Name"; // DOES NOT COMPILE - abstract conflicts with final
        
        public void eatPlants();
    }
    
    public interface Omnivore {
        public void eatPlants();
        public void eatMeat();
    }
    
    public class Bear implements Herbivore, Omnivore {
        
        @Override
        public void eatPlants() {
            System.out.println("Eating plants: 10");
        }

        @Override
        public void eatMeat() {
            System.out.println("eating meat");
        }
    }
}