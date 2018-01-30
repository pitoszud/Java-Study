/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticTests;

import java.util.Arrays;


public class StaticImports {
    
    
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        numC(sb);
        System.out.println(sb);
        
    }
    
    public static void numC(StringBuilder name){
        name.append("dupa");
    }    
    
    
}
