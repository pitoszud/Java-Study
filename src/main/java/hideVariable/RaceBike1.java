/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hideVariable;

import overVShidden.*;

/**
 *
 * @author UPatryk
 */
public class RaceBike1 {
    protected double weight = 7.2;
    public boolean isFast(){
        return true;
    }
    
    public void getRaceBikeDescription(){
        System.out.println("race weight is " + weight);
    }
}
