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
public class Main {
    public static void main(String[] args) {
        Cloud c = new Hail(); 
        c.precipitate(); // Hail: masive hail balls will make a dent in your car's roof
        c.getForcast(1); // Hail: Monday hail forecast
        
        c = new Snow();
        c.precipitate(); // Snow: heavy snowfall will cause delays across the country
        
        c = new Rain();
        c.precipitate(); // Rain: heavy showers will cause local flooding
        c.getForcast(1); // Rain: Monday rainfall forecast
        c.getForcast(0); // 7 day rain forecast
    }
    
}
