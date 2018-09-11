/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InnerClasses;

/**
 *
 * @author upatryk
 */
public class AnonExt {
    abstract class Discount{
        abstract double applyDisc();
    }
    
    interface Charge{
        double applySurcharge();
    }
    
    abstract class Quantity{
        abstract double quantify(double price, double quantity);
    }
    
    
    public class NamedClass extends Quantity{
        @Override
        double quantify(double price, double quantity) {
            return price * quantity;
        }
    }
    
    // inner class using abstract class
    public double calcPrice1(double price){
        Discount discount = new Discount(){
            @Override
            double applyDisc(){
                return price * 0.8;
            }
        };
        return discount.applyDisc();
    }
    
    
    // inner class using interface
    public double calcPrice2(double price){
        //double priceWithDisc = calcPrice1(price);
        // Charge charge = () -> price * 1.05;
        Charge charge = new Charge(){
            @Override
            public double applySurcharge(){ // must be public
                return price * 1.05;
            }
        };
        return charge.applySurcharge();
    }
    
    
    // separating calcPrice2 method
    public double calcStandardCost(double discount, Charge charge){
        return charge.applySurcharge() * discount;
    }
    
    public double calc(double price){
        //return calcStandardCost(0.5, () -> price * 1.07);

        return calcStandardCost(0.5, new Charge(){
            @Override
            public double applySurcharge(){
                return price * 1.07;
            }
        });
    }
    
    public static void main(String[] args) {
        AnonExt externalC = new AnonExt();
        double valD = externalC.calcPrice1(20.59);
        double valC = externalC.calcPrice2(valD);
        
        
        NamedClass nc = externalC.new NamedClass();
        double valQ = nc.quantify(valC, 5);
        
        double valE = externalC.calc(24.35);
        
        System.out.println(valC);
        System.out.println(valQ);
        System.out.println(valE);
        
        
    }
}
