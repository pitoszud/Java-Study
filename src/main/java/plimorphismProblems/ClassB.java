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
public class ClassB extends ClassA implements Cl {

    public void fly(){
        System.out.println("ClassB is flying");
    }

    public void hideOverride(int coresNum) {
        super.assignCores(coresNum);
    }
}