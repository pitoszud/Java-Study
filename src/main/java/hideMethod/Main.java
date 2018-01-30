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
public class Main {
    public static void main(String[] args) {
        Bike bike = new Bike();
        Bike.getBike();  // static method in Bike
        bike.getBicycle();  // instance method in Bike
        
        
        EnduranceBike endurBike = new EnduranceBike();
        endurBike.getBicycle();  // instance method in EnduranceBike
        EnduranceBike.getBike();  // static method in EnduranceBike
        
        
        bike = endurBike;
        Bike.getBike();  // static method in Bike
        bike.getBicycle();  // instance method in EnduranceBike
    }
}
