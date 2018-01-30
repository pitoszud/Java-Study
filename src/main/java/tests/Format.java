/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author patry
 */
public class Format {
    
    public static void main(String[] args) {
        formatNumber();
    }
    
    public static void formatNumber(){
        String s0 = String.format("|%f| |%s|", 12.9825F, "Android"); // |12.982500| |Android|
        System.out.println(s0);
        
        String s1 = String.format("|%15f| |%15s|", 12.9825F, "Android"); // |      12.982500| |        Android|
        System.out.println(s1);
        
        String s2 = String.format("|%-15f| |%-15s|", 12.9825F, "Android"); // |12.982500      | |Android        |
        System.out.println(s2);
        
        String s3 = String.format("|% f|", 12.9825F); // | 12.982500|
        System.out.println(s3);
        
        String s4 = String.format("|%.2f| |%.7s|", 12.9825F, "Android development"); // |12.98| |Android|
        System.out.println(s4);
        
        String s5 = String.format("|$%,d|", 129825); // |$129,825|
        System.out.println(s5);
        
        String s6 = String.format("|%x|", 129825); // |1fb21| => hex value
        System.out.println(s6);
        
        String s7 = String.format("|%d:%02d:%02d|", 6, 8, 8); // |1fb21| => hex value
        System.out.println(s7);
        
    }
}