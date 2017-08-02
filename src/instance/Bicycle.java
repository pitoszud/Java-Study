/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instance;

/**
 *
 * @author UPatryk
 */
public class Bicycle implements Vehicle {

    @Override
    public String propeller() {
        return "bottom bracket";
    }

    @Override
    public String fuel() {
        return "mucles";
    }

    @Override
    public String toString() {
        return "Bicycle";
    }
    
    
    
}
