/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pond.shore;

public class Bird {
    private double speed = 45.00; 
    protected String text = "floating"; // protected access
    static final String HA = "Ha";
    public static final String HAHA = "Ha, ha";
    
    protected void floatInWater() { // protected access
        System.out.println(text);
    }
    
    public static void dive(){
        System.out.println("going under water");
    }
    
    public void fly(){
        System.out.println("Bird is flying... ");
    }
    
    private void tweet(){
        System.out.println("tweet, tweet, tweet...");
    }
    
}
