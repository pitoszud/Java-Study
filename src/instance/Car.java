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
public class Car implements Vehicle {

    @Override
    public String propeller() {
        return "enginge";
    }

    @Override
    public String fuel() {
        return "unleaded";
    }
    
    @Override
    public String toString() {
        return "Car";
    }
    
}
