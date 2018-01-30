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
public class Student extends Teacher {
    private final int experience;
    
    public Student(int age){
        super(age);
        this.sex = "male";
        super.experience = 10;
        this.experience = 0;
        System.out.println("Student:");
        System.out.println("experience: " + super.experience);
        System.out.println("experience: " + this.experience);
    }
}
