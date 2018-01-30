/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author UPatryk
 */
public class Gorilla {
    public static int count;
    
    public static void addGorilla() {count++;}
    public void babyGorilla() { count++; }
    public void announceBabies() {
        addGorilla();
        babyGorilla();
    }
    
    public static void announceBabiesToEveryone() {
        addGorilla();
        // babyGorilla();
        new Gorilla().babyGorilla();
    }
    public int total;
    //public static double average = total / count;
    
}
