/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polimorphism;

/**
 *
 * @author UPatryk
 */
public class Lemur extends Primate implements HasTail {
    @Override
    public boolean isTailStriped() {
        return false;
    }
    @Override
    public String printName(){
        return "I am Lemur";
    }
    
    
    public int age = 10;
    public int weight = 10;

    public static void main(String[] args) {
        Lemur lemurA = new Lemur();
        System.out.println("age: " + lemurA.age); // 10
        
        
        HasTail hasTailA = lemurA;
        System.out.println(hasTailA.getClass()); // instance of Lemur / Lemur type
        System.out.println(hasTailA.isTailStriped()); // false - Lemur behaviour (overridden)
        //System.out.println(hasTailA.age); // DOES NOT COMPILE - an object ref (HasTail) can only have an access to its own variables or inherited
        //System.out.println(hasTailA.printName()); // DOES NOT COMPILE - an object ref (HasTail) can only have an access to its own methods or inherited
        
        
        Primate primateA = new Primate();
        System.out.println(primateA.getClass()); // instance of Primate / Primate type
        System.out.println(primateA.printName()); // I am Primate - instance of Primate / Primate type

        primateA = lemurA; // instance of Lemur - [superclass - subclass], so no casting required
        System.out.println(primateA.getClass()); // instance of Lemur / Lemur type
        System.out.println(primateA.hasHair()); // true - Primate behaviour (inherited / not overridden)
        System.out.println(primateA.printName()); // I am Lemur - overridden by instance of Lemur / Lemur type
        //System.out.println(primateA.age); // DOES NOT COMPILE - an instance of Lemur does not have an access to private variable in Primate class
        System.out.println(primateA.weight); // 20.0 - Primate state (inherited / not overridden)
        //System.out.println(primateA.isTailStriped());  // DOES NOT COMPILE - an object ref can only have an access to its own methods or inherited

        
        //lemurA = primateA; // DOES NOT COMPILE - you cannot reference from subclass to superclass without casting.
        Lemur lemurB = (Lemur) primateA; // instance of Lemur - [Lemur/subclass == Lemur/subclass], so casting is required
        System.out.println("class: " + lemurB.getClass()); // class: class polimorphism.Lemur
        System.out.println(lemurB.printName()); // I am Lemur
        System.out.println(lemurB.weight); // 10
        System.out.println(lemurB.hasHair()); // true
        
        
        Primate primateD = new Primate(); // instance of Primate
        //Lemur lemurX = (Lemur) primateD; // Runtime exception - java.lang.ClassCastException - Primate is not a subclass of Lemur
        
        
        Primate primateE = new Lemur(); // instance of Lemur
        if (primateE instanceof Lemur) {
            Lemur lemurE = (Lemur) primateE; // lemurE is an instance of Lemur (Lemur/subclass == Lemur/subclass)
            System.out.println(lemurE.isTailStriped());
        }
        
        Primate primateF = new Primate(); // instance of Primate
        if (primateF instanceof Lemur) {
            Lemur lemurF = (Lemur) primateF; // RUNTIME EXCEPTION - java.lang.ClassCastException - Primate is not a subclass of Lemur
            System.out.println(lemurF.isTailStriped());
        }
        else{
            System.out.println("Primate is not a subclass of Lemur. Only superclas - subclass allowed");
        }
    }
}
