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
public class EnduranceBike1 extends RaceBike1 {
    protected double weight = 8.6;
    
    @Override
    public boolean isFast(){
        return false;
    }
    
    public void getEnduranceBikeDescription(){
        System.out.println("endurance weight is " + this.weight + " comparing to race " + super.weight);
    }
}
