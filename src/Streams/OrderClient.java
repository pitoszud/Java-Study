/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Streams;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UPatryk
 */
public class OrderClient {
    public static void main(String[] args) {
        OrderFilter of = new OrderFilter();
        of.createAccountList();
        of.createOrders();
        List<Order> orders = of.getOrderList();
        
        List<Order> filteredList = of.filter(orders, ord -> ord.getAcc().equals("Pitos"));
        
        
    }
}
