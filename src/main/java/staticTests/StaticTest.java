/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticTests;

/**
 *
 * @author UPatryk
 */
public class StaticTest {
    private static String name1 = "John Smith";
    private String name2 = "Jan Kowalski";
    
    public static void main(String[] args) {
        
         
        // DOES NOT COMPILE - non-static method cannot be referenced from a static context
        // solution: make first() method static (no instance var parameters)
        // first();
        
        second(); // OK - method is static (no instance var parameters)
        third(); // OK - method is static + instance variable is static
        
        // DOES NOT COMPILE - non-static method cannot be referenced from a static context
        //solution: make forth() method static + make instance variable name2 static
        // forth();
        
        // fifth();
        
        new StaticTest().forth(); // OK - accessing non-static method without createing main ?
        
        
        // DOES NOT COMPILE - non-static variable this cannot be referenced from a static context
        // solution: replace this with class reference StaticTest.name1
        // System.out.println(this.name1);
    }
    
    public void first(){}
    public static void second(){}
    public static void third(){System.out.println(name1);}
    public void forth(){System.out.println(name2);}
    
    // DOES NOT COMPILE - non-static method cannot be referenced from a static context
    // solution: make name2 instance variable static
    // public static void fifth(){System.out.println(name2);}
}
