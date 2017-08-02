/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author upatryk
 */
public enum PrimitiveEnum {
    A(4.0), 
    B(3.0), 
    C(2.0), 
    D(1.0), 
    F(0.0);
    
    private final double value;

    private PrimitiveEnum(double v) { 
        this.value = v; 
    }
    
    public double value() { 
        return value; 
    }
    
}
