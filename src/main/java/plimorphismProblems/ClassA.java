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
public class ClassA implements Cl{
    // construction order problem
    private String[] coreArr;

    @Override
    public void assignCores(int coresNum){
        coreArr = new String[coresNum];
    }


    @Override
    public void fly(){
        System.out.println("ClassA is flying");
    }



}