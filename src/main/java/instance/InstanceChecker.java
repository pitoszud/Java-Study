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
public class InstanceChecker {
    public static void main(String[] args) {
        Vehicle v = new Car();
        if (v instanceof Car) {
            String vehicleType = v.getClass().getName();
            System.out.println("The propeller of " + vehicleType + " is " + v.propeller());
        }
        
        if (Car.class.isInstance(v)){
            System.out.println(v.getClass().getName());
        }
        
        if (Car.class.isAssignableFrom(v.getClass())) {
            System.out.println(v.getClass().getName());
        }
        
        try {
            Car c = (Car) v;
            //Car c = Car.class.cast(v);
        } catch (ClassCastException e) {
            System.out.println(e);
        }
        
        Wheel w = new Wheel();
        System.out.println(Car.class.isAssignableFrom(w.getClass())); // true 
        System.out.println(Bicycle.class.isAssignableFrom(w.getClass())); // false
        System.out.println(Wheel.class.isAssignableFrom(w.getClass())); // true
    }
}
