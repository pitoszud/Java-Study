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
public abstract class Cloud {
    String name = "Cloud";
    public abstract void precipitate();
    
    public void getForcast(int id){
        switch(id){
            case 0:
                displayForecast("7 day");
                break;
            case 1:
                displayForecast("Monday");
                break;
            case 2:
                displayForecast("Tuesday");
                break;
        }
    }
    
    
    public void displayForecast(String day){
        System.out.println(name + ": " + day + " weather forecast: ");
    }
}
