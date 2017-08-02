/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polimorphismInstanceof;

/**
 *
 * @author upatryk
 */
public class Test {
    
    public static void main(String[] args) {
        HeavyAnimal h = new Hippo(); 
        System.out.println(h instanceof Hippo); // true
        System.out.println(h instanceof HeavyAnimal); // true
        System.out.println(h instanceof Elephant); // false
        
        h = new HeavyAnimal(); 
        System.out.println(h instanceof HeavyAnimal); // true
        
        h = new Elephant(); 
        System.out.println(h instanceof Hippo); // false
        
        Elephant e = (Elephant) new HeavyAnimal(); // java.lang.ClassCastException
        
        
          
    }
    
}
