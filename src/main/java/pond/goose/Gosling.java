/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pond.goose;

import pond.shore.Bird; // must be imported to extend Bird

public class Gosling extends Bird { // extends means create subclass
        
    public void swim() {
        super.floatInWater(); // calling protected member Bird
        this.floatInWater(); // calling overriden method in Goosling
        System.out.println(text); // calling protected member
        // System.out.println(speed); // DOES NOT COMPILE - private access in Bird
    }
    
    public void helpMeWithTheSwim(){
        Gosling g = new Gosling();
        g.floatInWater(); // Gosling is extending Bird
        System.out.println(g.text);
    }

    /*
    
    @Override
    protected void fly(){ // DOES NOT COMPILE - (also private) weaker access privilige (public in Bird)
        System.out.println("Goosling is flying...");
    }

    */
    
    
    public void tweet(){
        System.out.println("cwir, cwir, cwir...");
    }
    
    public void helpBirdWithSwim(){
        Bird b = new Gosling(); // this class (Gosling) must import and extend Bird to create the Bird object
        // b.floatInWater();  // DOES NOT COMPILE - protected in Bird, Bird is referencing
        // System.out.println(b.text);  // DOES NOT COMPILE - protected in Bird, Bird is referencing
        // Bird.floatInWater(); // DOES NOT COMPILE - protected in Bird + non-static method
        Bird.dive(); // calling public + static method
        b.fly(); // calling public method in Bird
        this.fly(); // calling public method in Goosling
        // String haStr = Bird.HA;  // DOES NOT COMPILE - default is not accessed outside shore package
        String haHaStrIndirect = Bird.HAHA; // accessing variable with public access modifier
        String haHaStrDirect = HAHA; // this class (Gosling) must import and extend Bird to access var directly
        // if not extended than import STATIC pond.shore.Bird.*; or import STATIC pond.shore.Bird.HAHA; must be used
        Bird bg = new Gosling();
        // bg.tweet(); // DOES NOT COMPILE - private access in Bird
    }

    
    @Override
    public void floatInWater(){
        System.out.println("floating Goosling");
    }
}