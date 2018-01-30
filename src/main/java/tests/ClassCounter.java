/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author UPatryk
 */
public class ClassCounter {
    private static int count;
    
    public ClassCounter(){count++;}
    
    public static int getCount() {
        return count;
    }

    public static void setStaticCount(int count) {
        ClassCounter.count = count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    public static void main(String[] args) {
        ClassCounter cc1 = new ClassCounter();
        ClassCounter cc2 = new ClassCounter();
        ClassCounter cc3 = new ClassCounter();
        
        System.out.println(count); //3
        System.out.println(ClassCounter.count); //3
        System.out.println(cc3.getCount()); //3
        System.out.println(ClassCounter.getCount()); //3 
        
        System.out.println(new ClassCounter().getCount()); //4
        
        cc3.setCount(1); 
        System.out.println(count); //1
        
        ClassCounter cc5 = new ClassCounter();
        System.out.println(count); //2
        
        cc5.setStaticCount(1);
        System.out.println(count); //1
        
    }
}
