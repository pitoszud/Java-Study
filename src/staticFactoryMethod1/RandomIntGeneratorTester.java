/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticFactoryMethod1;

/**
 *
 * @author upatryk
 */
public class RandomIntGeneratorTester {
    public static void main(String[] args) {
        RandomIntGeneratorConstructor rig1 = new RandomIntGeneratorConstructor(5, 10);
        System.out.println(rig1.getMin() + " " + rig1.getMax());
        
        rig1 = new RandomIntGeneratorConstructor(5);
        System.out.println(rig1.getMin());
        
        // no constructor for RandomIntGenerator1(int max) as it is
        // the same type as RandomIntGenerator1(int min)
       
        System.out.println("-------------------------------");
        
        
        RandomIntGenerator rig2 = RandomIntGenerator.between(5, 10);
        System.out.println(rig2.getMin() + " " + rig2.getMax());
        
        rig2 = RandomIntGenerator.smallerThan(10);
        System.out.println(rig2.getMax());
        
        rig2 = RandomIntGenerator.biggerThan(6);
        System.out.println(rig2.getMin());
        
        System.out.println("--------------------------------");
        
        RandomGenerator rgInt = RandomGenerators.getIntGenerator();
        System.out.println(rgInt.next());
        RandomGenerator rgDb = RandomGenerators.getDoubleGenerator();
        System.out.println(rgDb.next());
    }
}
