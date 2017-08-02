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
public class Snow extends Cloud {
    
    public Snow(){
        name = "Snow";
    }
    

    @Override
    public void precipitate() {
        makeDelays();
    }
    
    private void makeDelays(){
        System.out.println(name + ": heavy snowfall will cause delays across the country");
    }
    
    @Override
    public void displayForecast(String day){
        System.out.println(name + ": " + day + " snow forecast");
    }
    
}
