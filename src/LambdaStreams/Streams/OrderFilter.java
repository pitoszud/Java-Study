/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LambdaStreams.Streams;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UPatryk
 */
public class OrderFilter {
    List<Account> accList = new ArrayList<>();
    List<Order> orderList = new ArrayList<>();
    
    public void createAccountList(){
        accList.add(new Account(123456,"Pitos",4000.00,35));
        accList.add(new Account(123457,"Iwona",3000.00,34));
        accList.add(new Account(123458,"Oliwia",6000.00,2));
        accList.add(new Account(123459,"Kasia",8000.00,36));
        accList.add(new Account(123460,"Staszek",3000.00,40));
        accList.add(new Account(123461,"Lukasz",9000.00,31));
    }
    
    public void createOrders(){
        orderList.add(new Order(654321,"Ball",accList.get(0),25.50));
        orderList.add(new Order(654321,"Bucket",accList.get(1),30.80));
        orderList.add(new Order(654321,"Tea pot",accList.get(2),15.50));
        orderList.add(new Order(654321,"hat",accList.get(3),50.60));
        orderList.add(new Order(654321,"bicycle",accList.get(4),20.00));
        orderList.add(new Order(654321,"cup",accList.get(5),21.30));
    }
    
    public List<Order> filter(List<Order> ol, OrderPredicate op){
        List<Order> orderedList = new ArrayList<>();
        for (Order order : orderedList) {
            if(op.test(order)){
                orderedList.add(order);
            }
        }
        return orderedList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
    
    
    
}
