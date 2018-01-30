/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructorA;

/**
 *
 * @author UPatryk
 */
public class Teacher extends Person { 
    protected int experience;
    
    public Teacher(int age) { 
        super(age, "Albert");
        System.out.println("Teacher:"); 
    }
    
//    public Teacher(){  // null, 5 
//        super(5);  
//    } 
     
    public Teacher(){  // 4, Albert 
        this(4); 
        this.experience = 3;
    } 
} 
