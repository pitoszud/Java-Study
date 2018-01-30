/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compare;

import java.lang.reflect.Method;

/**
 *
 * @author upatryk
 */
public class Stork implements Comparable {
    String name;
    int weight;
    
    public Stork(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    
    @Override
    public String toString(){
        return name + " weight " + weight;
    }

    @Override
    public int compareTo(Object o) {
        return compareTo((Stork)o);
    }
    
    public int compareTo(Stork s){
        return this.weight < s.weight ? -1 : this.weight == s.weight ? 0 : 1;
    }
}
