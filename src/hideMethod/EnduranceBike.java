/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hideMethod;

/**
 *
 * @author UPatryk
 */
public class EnduranceBike extends Bike {
    
    // hiding 
    public static void getBike(){
        System.out.println("static method in EnduranceBike");
    }
    
    
    @Override
    public void getBicycle(){
        System.out.println("instance method in EnduranceBike");
    }
    
    
}
