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
public class Qualification {
    private final String name;
        
    public Qualification(String name){
        this.name = name;
    }
    
    public String getQualificationName(){
        return this.name;
    }
}
