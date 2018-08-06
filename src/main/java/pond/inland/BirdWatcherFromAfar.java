/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pond.inland;

import pond.shore.Bird; // must be imported to extend Bird

public class BirdWatcherFromAfar extends Bird {
    public void watchBird() {
        floatInWater(); // BirdWatcherFromAfar is referencing and extends Bird
        Bird bird = new Bird(); // Bird is created in different package than pond.shore
        //bird.floatInWater(); // DOES NOT COMPILE - protected in Bird, Bird is referencing
        //System.out.println(bird.text); // DOES NOT COMPILE - protected in Bird, Bird is referencing
    } 
}