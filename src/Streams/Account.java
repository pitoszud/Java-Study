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
public class Account {
    private long accNum;
    private String accName;
    private double credit;
    private int age;
    
    public Account(long accNum, String accName, double credit, int age){
        this.accNum = accNum;
        this.accName = accName;
        this.credit = credit;
        this.age = age;
    }

    public long getAccNum() {
        return accNum;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    

    @Override
    public String toString() {
        return "Account{" + "accNum=" + accNum + ", accName=" + accName + ", credit=" + credit + '}';
    }
    
}
