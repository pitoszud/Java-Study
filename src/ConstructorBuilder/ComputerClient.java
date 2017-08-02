/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConstructorBuilder;
import ConstructorBuilder.Computer.CompBuilder;

/**
 *
 * @author UPatryk
 */
public class ComputerClient {
    public static void main(String[] args) {
        Computer comp0 = new Computer.CompBuilder("i7", 32, "ssd")
                .screenSize(27)
                .gpu("nvida640")
                .build();
        System.out.println(comp0.toString());
        
        Computer comp = Computer.getMediumComputer();
        System.out.println(comp.toString());
        
        Computer comp2 = Computer.setMediumComputer("i5", 32, "ssd");
        System.out.println(comp2.toString());
    }
    
}
