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
public class Person {
    private int age;
    private String name;
    protected String sex;
    
    public Person(int age, String name){
        this.age = age;
        this.name = name;
        System.out.println("Person:");
    }
    
    public Person(int age){
        this.age = age;
        this.name = null;
    }

    
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    
}
