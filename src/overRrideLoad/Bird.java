/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overRrideLoad;

/**
 *
 * @author UPatryk
 */
public class Bird {
    public void fly() throws InsufficientDataException{
        System.out.println("Bird is flying");
    }
    protected String run(String str){
        return str;
    }
    
    public static void eat(int food){
        System.out.println("Bird is eating " + food + " units of food.");
    }
    
    public int getInt(int num){
        return num;
    }
    
    public Number getInt(){
        return 1;
    }
    
    
    public class InsufficientDataException extends Exception{
    
    }
}

