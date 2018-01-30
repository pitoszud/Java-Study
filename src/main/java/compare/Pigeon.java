/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compare;

/**
 *
 * @author UPatryk
 */
public class Pigeon implements Comparable<Pigeon> { 
    String name; 
    int weight; 
   
    public Pigeon(String name, int weight) { 
        this.name = name; 
        this.weight = weight; 
    } 

    @Override
    public String toString() { 
        return name + " weighs " + weight; 
    } 


    @Override 
    public int compareTo(Pigeon pigeon) { 
        Pigeon otherPigeon = (Pigeon)pigeon; 
        return this.weight - otherPigeon.weight; 
    }
    
    
    public int compareTo2(Pigeon pigeon) { 
        return this.weight < pigeon.weight ? - 1 : this.weight == pigeon.weight ? 0 : 1;
    }
    
    
}