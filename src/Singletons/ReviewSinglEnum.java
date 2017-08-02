/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singletons;

/**
 *
 * @author UPatryk
 */
public enum ReviewSinglEnum {
    INSTANCE;
    
    public void writeReview(String str){
        System.out.println(str);
    }
}
