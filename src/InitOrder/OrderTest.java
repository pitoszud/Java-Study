/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InitOrder;

import InitOrder.Order;

/**
 *
 * @author UPatryk
 */
public class OrderTest {
    
    public static void main(String[] args) {
        testOrder1();
        //testOrder2();
    }
    
    public static void testOrder1(){
        System.out.println(Order.res + " : " + Order.num); // u : 10
        System.out.println(Order.res + " : " + Order.num); // u : 10
        
        Order ord = new Order();
        System.out.println(ord.getRes() + " : " + Order.num); // ucr : 21 => u+cr : 10+1+5+5
        Order ord2 = new Order(); 
        System.out.println(ord2.getRes() + " : " + Order.num); // ucrcr : 32 => ucr+cr : 21+1+5+5
        
        new Order(); 
        System.out.println(Order.res + " : " + Order.num); // ucrcrcr : 43 => ucrcr+cr : 32+1+5+5
        System.out.println(Order.res + " : " + Order.num + "\n"); // ucrcrcr : 43 => no change
    }
    
    public static void testOrder2(){
        System.out.println(Order.res + " : " + Order.num); // u : 10
        System.out.println(Order.res + " : " + Order.num+1); // u : 101
        System.out.println(Order.res + " : " + Order.num); // u : 10
        new Order();
        System.out.println(Order.res + " : " + Order.num); // ucr : 21  => u+cr : 10+1+5+5
        new Order();
        System.out.println(Order.res + " : " + Order.num + "\n"); // ucrcr : 32  => ucr+cr : 20+1+5+5
    }
}
