/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LambdaStreams.Streams;

import java.util.List;
import java.util.function.Predicate;

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
        
        List<Order> filteredList1 = of.filter(orders, ord -> ord.getAcc().equals("Pitos"));


        OrderPredicate pitosAccount2 = ord -> ord.getAcc().equals("Pitos");
        List<Order> filteredList2 = of.filter(orders, pitosAccount2);


        Predicate<Order> predicate = ord -> ord.getAcc().equals("Pitos");
        OrderPredicate pitosAccount3 = (OrderPredicate) predicate;
        List<Order> filteredList3 = of.filter(orders, pitosAccount3);

        
    }
}
