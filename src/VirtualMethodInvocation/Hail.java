/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualMethodInvocation;

/**
 *
 * @author upatryk
 */
public class Hail extends Cloud {
    
    public Hail(){
        name = "Hail";
    }
    

    @Override
    public void precipitate() {
        makeDamage();
    }
    
    private void makeDamage(){
        System.out.println(name + ": masive hail balls will make a dent in your car's roof");
    }
    
    @Override
    public void displayForecast(String day){
        System.out.println(name + ": " + day + " hail forecast");
    }
    
}
