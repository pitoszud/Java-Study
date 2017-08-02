/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author upatryk
 */
public class CustomExc {
    
    public class MissingRoundingException extends Exception{
        public MissingRoundingException(String message){
            super(message);
        }
        
        public MissingRoundingException(String message, Throwable throwable){
            super(message,throwable);
        }
    }
    
    public class Calculator{
        
        public void divide(double a, double b) throws MissingRoundingException{
            double c = a/b;
            String cStr = String.valueOf(c);
            if (cStr.length() > 6) {
                throw new MissingRoundingException("num must be rounded to 2 dec");
            }
        }
        
        public void divideAndUplift(double a, double b){
            double c = (a/b)*0.05;
            String cStr = String.valueOf(c);
            try {
                if (cStr.length() > 6) {
                    throw new MissingRoundingException("num must be rounded to 2 dec");
                }
            } catch (MissingRoundingException e) {
                System.err.println(e);
            }
        }
        
        
    }
    
    public static void main(String[] args) {
        
    }
}
