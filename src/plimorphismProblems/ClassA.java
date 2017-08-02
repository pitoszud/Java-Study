/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plimorphismProblems;

/**
 *
 * @author UPatryk
 */
public class ClassA{
    private void fly(){
        System.out.println("ClassA");
    }
    
    public static void main(String[] args) {
        //???????????????????????????????????????????????????????????????????
        ClassA cl1 = new ClassB(); // instance of ClassB
        cl1.fly(); // ClassA
        
        ClassB cl3 = new ClassB(); // instance of ClassB
        cl3.fly(); // ClassB
        
        ClassA cl2 = new ClassA();  // instance of ClassA
        cl2.fly(); // ClassA
    }
}