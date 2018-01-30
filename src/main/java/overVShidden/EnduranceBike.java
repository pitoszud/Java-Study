/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overVShidden;

/**
 *
 * @author UPatryk
 */
public class EnduranceBike extends RaceBike {
    
    @Override
    public boolean isFast(){
        return false;
    }
    
    public void getEnduranceBikeDescription(){
        System.out.println("endurance bike is fast: " + isFast());
    }
}
