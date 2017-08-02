/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Streams;

/**
 *
 * @author UPatryk
 */
public class Order {
    private long orderNum;
    private String product;
    private Account acc;
    private double value;
    
    public Order(long orderNum, String product, Account acc, double value){
        this.orderNum = orderNum;
        this.product = product;
        this.acc = acc;
        this.value = value;
    }

    public long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(long orderNum) {
        this.orderNum = orderNum;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public double getValue() {
        return value;
    }
    
    
    
    
}
