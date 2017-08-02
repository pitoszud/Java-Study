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
public class Main {
    public static void main(String[] args) {
        Person p = new Person(10, "Name");
        System.out.println(p.getAge() + ", " + p.getName());
        
        System.out.println("");
        
        Teacher t = new Teacher();
        System.out.println(t.getAge() + ", " + t.getName());
        
        System.out.println("");
        
        Student s = new Student(13);
        System.out.println(s.getAge() + ", " + s.getName());
        
        
    }
}
