/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overRrideLoad;

// overload: type + signature or signature changed
// override: type, signature, exception stay the same
// error: type changed
public class Eagle extends Bird {
    
    public int fly(int height){ // overloaded - signature changed
        System.out.println(height);
        return height;
    }
    
    @Override
    public void fly(){ // overriden with exception
        System.out.println("text");
    }
    
    public int getInt(double num, String str){ // overladed - signature changed
        return 1;
    }
    
    @Override
    public Integer getInt(){ // overriden - Integer is a subclass of Number
        return 2;
    }
    
    public int run(int age, String name){ // overloaded - type + signature changed
        return age;
    }
    
    public String run(){ // overloaded - signature changed
        return "";
    }
    
    // DOES NOT COMPILE - type changed (not covariant)
    public Long run(String name){
        return 5L;
    }
    
    
    // DOES NOT COMPILE - exception is broader
    private String run(String str){
        return "";
    }
    
    // ignore error - String run(String str) already defined
    @Override
    public String run(String str){ // overriden - no change to type and signature
        return " name";
    }
    
    
    public Double run(Double db){ // overloaded - type + signature different
        return db;
    }
    
    public int run(String name, int num){ // overloaded - type + signature different
        return 5;
    }
    
    public String run(String firstName, String secondName){ // overloaded - type + signature different
        return firstName;
    }
    
    
    public Double run(double db){ // overloaded - type + signature different
        return db;
    }
    
    
    // DOES NOT COMPILE - overriden method in Bird is static
    @Override
    public void eat(int food){
        System.out.println("Bird is eating " + food + " units of food.");
    }
    
    public static void eat(){ // overloaded - signature changed
        System.out.println("eat something");
    }
    
    
}
