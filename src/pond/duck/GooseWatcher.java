/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pond.duck;
import pond.goose.Gosling;

/**
 *
 * @author UPatryk
 */
public class GooseWatcher {
    public void watch(){
        Gosling g = new Gosling();
        g.floatInWater(); // DOES NOT COMPILE - protected in Bird, Gosling is referencing
    }
}
