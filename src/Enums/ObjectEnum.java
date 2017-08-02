/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * enumerated Objects
 */
public enum ObjectEnum {
    networking(new Qualification("BSc in Networking")), 
    computing(new Qualification("BSc in Computing")),
    software(new Qualification("BSc in Software Enginering")); 
 
    private final Qualification value; 
 
    private ObjectEnum(Qualification value) { 
        this.value = value; 
    } 
 
    public Qualification value() { 
        return value; 
    }
    
}
