/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pond.swan;

import pond.shore.Bird; // must be imported to extend Bird

public class Swan extends Bird { // but subclass of bird
    public void swim() {
        super.floatInWater(); // Swan is referencing and extends Bird
        System.out.println(text); // package access to superclass, Swan is referencing
    }
    
    public void helpOtherSwanSwim(){
        Swan s = new Swan();
        s.floatInWater(); // package access to superclass, Swan is referencing
        System.out.println(s.text); // package access to superclass, Swan is referencing
    }
    
    public void helpOtherBirdSwim(){
        Bird b = new Bird();
        b.floatInWater(); // DOES NOT COMPILE - protected in Bird, Bird is referencing
        System.out.println(b.text);  // DOES NOT COMPILE - protected in Bird, Bird is referencing
    }
}