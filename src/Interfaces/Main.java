/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author UPatryk
 */
public class Main {
    public static void main(String[] args) {
        InterfaceEx4 i4 = new InterfaceEx4();
        
        InterfaceEx4.Bear i4Bear = i4.new Bear();
        i4Bear.getName();
        
        InterfaceEx4.Bear2 i4Bear2 = i4.new Bear2();
        i4Bear2.getName();
        
        InterfaceEx4.Doe i4doe = i4.new Doe();
        i4doe.getName();
    }
}
