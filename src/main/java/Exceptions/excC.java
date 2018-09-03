/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author UPatryk
 */
public class excC {
    class FlatTyre extends Exception {}
    class FlatTyres extends Exception {}
    class ChainSnapped extends Exception {}
    
    public static class Cyclist{
        public static void main(String[] args) throws FlatTyres {// option 1 - throws FlatTyre
            // option 2
            try {
                rideFast();
            } catch (FlatTyre fte) {
                System.err.println(fte);
            }
            
            rideVeryFast(); // unreported exception FlatTyres - must be caught or declated to be thrown

            /*

            try {
                rideSlow();
            } catch (ChainSnapped csn) { // ChainSnapped never thrown in body of try statement - add throws ChainSnapped to rideSlow()
                System.err.println(csn);
            }

            */
        }
        
        public static void main2(String[] args) throws FlatTyre, FlatTyres { 
            rideFast();
            rideVeryFast();
            rideSlow();
           
        }
        
        public static void rideFast() throws FlatTyre{
            System.out.println("riding at 40km/h");
        }
        
        public static void rideVeryFast() throws FlatTyres{
            System.out.println("riding at 50km/h");
        }
        
        public static void rideSlow() { 
            System.out.println("riding at 15km/h");
        }
    }
    
    public static class Bike extends Cyclist{
        public static void rideSlow() throws IllegalStateException{ // OK to throw any runtime exception
            
        }
        
        public static void rideFast() { // inherites FlatTyre from Cyclist - throw is optional
            
        }
    }
}
