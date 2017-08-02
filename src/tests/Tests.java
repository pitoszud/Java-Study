/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author UPatryk
 */
public class Tests {
    int num;
    String str;
    
    public Tests(int num, String str){
        this.num = num;
        this.str = str;
    }
    
    public Tests(int num){
        // comment
        this(num, "Name");
    }
    
    public static void main(String[] args) {
        Tests t = new Tests(4, "Pitos");
    }
}


