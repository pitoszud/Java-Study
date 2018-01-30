/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compare;

import java.util.Comparator;

/**
 *
 * @author UPatryk
 */
public class Sparrow implements Comparator<Sparrow> { 
    String name; 
    int weight; 
 
    public Sparrow(String name, int weight) { 
            this.name = name; 
            this.weight = weight; 
    } 
 
    @Override 
    public String toString() { 
            return name + " weighs " + weight; 
    } 
         
 
    @Override 
    public int compare(Sparrow obj1, Sparrow obj2) { 
             return (obj1.weight < obj2.weight) ? -1: (obj1.weight > obj2.weight) ? 1 : 0;
          //return obj1.name.compareTo(obj2.name); 
 
        // int compare(Object o1,Object o2) 
        // 1. positive – o1 is greater than o2 
        // 2. zero – o1 equals to o2 
        // 3. negative – o1 is less than o1 
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
    
    
    
} 