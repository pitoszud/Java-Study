/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singletons;

/**
 *
 * Static factory with private member
 */
public class ReviewSinglFactory {
    private static final ReviewSinglFactory INSTANCE = new ReviewSinglFactory();
    
    private ReviewSinglFactory(){}
    
    public static ReviewSinglFactory getInstance(){
        return INSTANCE;
    }
    
    public void writeReview(String str){
        System.out.println(str);
    }
}
