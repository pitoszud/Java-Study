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
public class Rain extends Cloud {
    
    public Rain(){
        name = "Rain";
    }

    @Override
    public void precipitate() {
        makeFloods();
    }
    
    private void makeFloods(){
        System.out.println(name + ": heavy showers will cause local flooding");
    }
    
    @Override
    public void displayForecast(String day){
        if (day.equals("7 day")) {
            super.displayForecast(day);
        } else{
            System.out.println(name + ": " + day + " rain forecast");
        }
    }
    
}
