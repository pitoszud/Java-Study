/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singletons.FactoryAndEnum;

/**
 *
 * @author UPatryk
 */
public class Main {
    public static void main(String[] args) {
        ReviewSinglFactory.getInstance().writeReview("review about the film");
        ReviewSinglEnum.INSTANCE.writeReview("reviw about the book");
    }
}
